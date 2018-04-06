package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;

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

    public Object login(LoginCredentials loginCredentials) {
        Customer user = customerRepository.findCustomerByUserID(loginCredentials.getUserId());
        if (user == null) {
            return null;
        }

        boolean decrypted = PasswordEncryption.decrypt(loginCredentials.getUserId(), loginCredentials.getPassword(),
                user.getPassword());

        if (loginCredentials.getUserId().equals(user.getUserID()) && decrypted) {
            if (loginCredentials.getUserId().equals(loginCredentials.getPassword()) && !user.isChangedPassword()) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    user.setChangedPassword(true);
                    customerRepository.save(user);
                    return mapper.writeValueAsString("Password exists");
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            } else {
                return vehicleLeasingRepository.findVehicleLeasingsByCustomerID(user.getId().toString());
            }
        }
        return null;
    }

    public Object administratorLogin(LoginCredentials loginCredentials) {

        //Add new admin with default credentials
        /*String hashedPass = PasswordEncryption.encrypt(loginCredentials.getUserId(), loginCredentials.getPassword());

        Administrator admin = new Administrator();
        admin.setUserID(loginCredentials.getUserId());
        admin.setPassword(hashedPass);

        administratorRepository.save(admin);*/

        Administrator administrator = administratorRepository.findAdministratorByUserID(loginCredentials.getUserId());
        if (administrator == null) {
            return new ResponseEntity<>("Invalid user", HttpStatus.BAD_REQUEST);
        } else {

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
                return customerLoans;
            } else {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.NOT_FOUND);
            }
        }
    }

    public List<VehicleLeasingResponse> changePassword(PasswordRequest passwordRequest) {

        String userId = passwordRequest.getUserId();
        String oldPassword = passwordRequest.getOldPassword();
        String newPassword = passwordRequest.getNewPassword();

        Customer customer = customerRepository.findCustomerByUserID(userId);
        System.out.println(customer);

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


        PasswordResetToken tokenRep = resetTokenRepository.findByToken(token);

        Customer customer = customerRepository.findCustomerByUserID(userId);
        if (customer == null || tokenRep == null || (!tokenRep.getCustomerID().equals(userId))) {
            System.out.println("bad token");
            return false;
        }

        String encryptedPass = PasswordEncryption.encrypt(userId, newPassword);
        customer.setPassword(encryptedPass);
        customerRepository.save(customer);

        resetTokenRepository.delete(tokenRep);

        return true;
    }
}
