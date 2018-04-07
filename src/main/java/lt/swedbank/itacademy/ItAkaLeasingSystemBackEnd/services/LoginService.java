package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Administrator;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.CustomerLoans;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.LoginCredentials;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.PasswordRequest;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.tokens.PasswordResetToken;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.AdministratorRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.CustomerRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.ResetTokenRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.VehicleLeasingRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private VehicleLeasingRepository vehicleLeasingRepository;

    @Autowired
    private ResetTokenRepository resetTokenRepository;

    public String login(LoginCredentials loginCredentials) {
        Optional<Customer> userOptional = customerRepository.findCustomerByUserID(loginCredentials.getUserId());
        if (!userOptional.isPresent()) {
            return null;
        }

        Customer user = userOptional.get();
        boolean decrypted = PasswordEncryption.decrypt(loginCredentials.getUserId(), loginCredentials.getPassword(),
                user.getPassword());

        if (loginCredentials.getUserId().equals(user.getUserID()) && decrypted) {
            if (loginCredentials.getUserId().equals(loginCredentials.getPassword()) && !user.isChangedPassword()) {
                try {
                    user.setChangedPassword(true);
                    customerRepository.save(user);
                    return new ObjectMapper().writeValueAsString("first login");
                }
                catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    return new ObjectMapper().writeValueAsString(createJWToken("user", "user"));
                }
                catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public Object administratorLogin(LoginCredentials loginCredentials) {

        //Add new admin with default credentials
        if(administratorRepository.findAll().isEmpty()){
            String hashedPass = PasswordEncryption.encrypt("admin", "root");

            Administrator admin = new Administrator();
            admin.setUserID("admin");
            admin.setPassword(hashedPass);
            administratorRepository.save(admin);
        }
        Optional<Administrator> optional = administratorRepository.findAdministratorByUserID(loginCredentials.getUserId());
        if (!optional.isPresent()) {
            return new ResponseEntity<>("Invalid user", HttpStatus.BAD_REQUEST);
        } else {
            Administrator administrator = optional.get();
            boolean decrypted = PasswordEncryption.decrypt(loginCredentials.getUserId(), loginCredentials.getPassword(),
                    administrator.getPassword());
            if (decrypted) {

                List<Customer> customers = customerRepository.findAll();
                List<CustomerLoans> customerLoans = new ArrayList<>();
                for(Customer customer : customers){
                    List<VehicleLeasing> customerLeasings =
                            vehicleLeasingRepository.findVehicleLeasingsByCustomerID(customer.getId().toString());
                    customerLoans.add(new CustomerLoans(customer, customerLeasings));
                }

                try {
                    return new ObjectMapper().writeValueAsString(createJWToken("admin", "admin"));
                }
                catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
            else {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.NOT_FOUND);
            }
        }
        return null;
    }

    public List<VehicleLeasingResponse> changePassword(PasswordRequest passwordRequest) {

        String userId = passwordRequest.getUserId();
        String oldPassword = passwordRequest.getOldPassword();
        String newPassword = passwordRequest.getNewPassword();

        Optional<Customer> optional = customerRepository.findCustomerByUserID(userId);
        if(!optional.isPresent()){
            return null;
        }

        Customer customer = optional.get();
        boolean decryptedOldPassLegit = PasswordEncryption.decrypt(userId, oldPassword,
                customer.getPassword());
        if (!decryptedOldPassLegit) {
            throw new IllegalArgumentException("Specified old password does not equal customer's password");
        } else {

            String encryptedPass = PasswordEncryption.encrypt(userId, newPassword);
            customer.setPassword(encryptedPass);
            //customer.setPassword(passwordRequest.getNewPassword());
            customerRepository.save(customer);

            List<VehicleLeasingResponse> responses = new ArrayList<>();
            for (VehicleLeasing vehicleLeasing : vehicleLeasingRepository
                    .findVehicleLeasingsByCustomerID(customer.getId().toString())) {
                responses.add(new VehicleLeasingResponse(vehicleLeasing));
            }

            return responses;
        }
    }

    public boolean passwordRecovery(PasswordRequest passwordRequest) {

        String userId = passwordRequest.getUserId();
        String token = passwordRequest.getOldPassword();
        String newPassword = passwordRequest.getNewPassword();


        Optional<PasswordResetToken> optionalToken = resetTokenRepository.findByToken(token);
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByUserID(userId);
        if (!optionalToken.isPresent()||!optionalCustomer.isPresent()|| (!optionalToken.get().getCustomerID().equals(userId))) {
            System.out.println("bad token");
            return false;
        }

        Customer customer = optionalCustomer.get();
        PasswordResetToken tokenRep = optionalToken.get();

        String encryptedPass = PasswordEncryption.encrypt(userId, newPassword);
        customer.setPassword(encryptedPass);
        customerRepository.save(customer);

        resetTokenRepository.delete(tokenRep);

        return true;
    }

    private String createJWToken(String subject, String roles){
        return Jwts.builder().setSubject(subject).claim("roles", roles).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
    }
}
