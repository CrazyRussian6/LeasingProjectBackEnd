package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//<<<<<<< HEAD
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Administrator;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.errors.ErrorDetails;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.Login;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.PasswordRequest;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.AdministratorRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.CustomerRepository;
//=======
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
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.VehicleLeasingRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

import java.util.Date;
import java.util.List;
import java.util.Optional;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6

@Service
public class LoginService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private VehicleLeasingRepository vehicleLeasingRepository;

/*<<<<<<< HEAD
    public Object login(Login login) {
        if(login.getUserId().equals("admin") && login.getPassword().equals("root")){
            return this.administratorLogin(login);
        }

        List<Customer> customers = new ArrayList<>(customerRepository.findAll());
        List<String> errorMessage = new ArrayList<>();
        ErrorDetails loginError = new ErrorDetails("LoginError", "LoginError", errorMessage);
        for (Customer user : customers) {

            Customer customer = customerRepository.findCustomerByUserID(login.getUserId());
            if(customer == null){
                return null;
            }

            boolean decrypted = PasswordEncryption.decrypt(login.getUserId(), login.getPassword(),
                    customer.getPassword());

            if (login.getUserId().equals(user.getUserID()) && decrypted) {
                if (login.getUserId().equals(login.getPassword()) && !user.isChangedPassword()) {
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        user.setChangedPassword(true);
                        customerRepository.save(user);
                        return mapper.writeValueAsString("Password exists");
                    }
                    catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    return vehicleLeasingRepository.findVehicleLeasingsByCustomerID(user.getId().toString());
=======*/
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
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
                }
            }
        }
        return null;
    }

/*<<<<<<< HEAD
    public ResponseEntity<String> administratorLogin(Login login){

        //Add new admin with default credentials
        /*String hashedPass = PasswordEncryption.encrypt(login.getUserId(), login.getPassword());

        Administrator admin = new Administrator();
        admin.setUserID(login.getUserId());
        admin.setPassword(hashedPass);

        administratorRepository.save(admin);*/
/*
        Administrator administrator = administratorRepository.findAdministratorByUserID(login.getUserId());
        if(administrator == null){
            return new ResponseEntity<>("Invalid user", HttpStatus.BAD_REQUEST);
        }
        else{

            boolean decrypted = PasswordEncryption.decrypt(login.getUserId(), login.getPassword(),
                    administrator.getPassword());
            if(decrypted){
                return new ResponseEntity<>("Admin", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Invalid credentials", HttpStatus.NOT_FOUND);
            }

        }
=======*/
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
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    }

    public List<VehicleLeasingResponse> changePassword(PasswordRequest passwordRequest) {

        String userId = passwordRequest.getUserId();
        String oldPassword = passwordRequest.getOldPassword();
        String newPassword = passwordRequest.getNewPassword();

/*<<<<<<< HEAD
        Customer customer = customerRepository.findCustomerByUserID(userId);

        boolean decryptedOldPassLegit = PasswordEncryption.decrypt(userId, oldPassword,
                customerRepository.findCustomerByUserID(userId).getPassword());
=======*/
        Optional<Customer> optional = customerRepository.findCustomerByUserID(userId);
        if (!optional.isPresent()) {
            return null;
        }

        Customer customer = optional.get();
        boolean decryptedOldPassLegit = PasswordEncryption.decrypt(userId, oldPassword,
                customer.getPassword());
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
        if (!decryptedOldPassLegit) {
            throw new IllegalArgumentException("Specified old password does not equal customer's password");
        } else {

            String encryptedPass = PasswordEncryption.encrypt(userId, newPassword);
            customer.setPassword(encryptedPass);
            //customer.setPassword(passwordRequest.getNewPassword());
            customerRepository.save(customer);

            List<VehicleLeasingResponse> responses = new ArrayList<>();
/*<<<<<<< HEAD
            for(VehicleLeasing vehicleLeasing : vehicleLeasingRepository
                    .findVehicleLeasingsByCustomerID(customer.getId().toString())){
=======*/
            for (VehicleLeasing vehicleLeasing : vehicleLeasingRepository
                    .findVehicleLeasingsByCustomerID(customer.getId().toString())) {
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
                responses.add(new VehicleLeasingResponse(vehicleLeasing));
            }

            return responses;
        }
        //    }
    }
/*<<<<<<< HEAD
    public boolean passwordRecovery(PasswordRequest passwordRequest){

        if(passwordRequest.getOldPassword() != null){
            return false;
        }

        String userId = passwordRequest.getUserId();
        String newPassword = passwordRequest.getNewPassword();

        Customer customer = customerRepository.findCustomerByUserID(userId);
        if(customer == null){
            return false;
        }

=======*/
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

//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
        String encryptedPass = PasswordEncryption.encrypt(userId, newPassword);
        customer.setPassword(encryptedPass);
        customerRepository.save(customer);

/*<<<<<<< HEAD
        return true;
    }
=======*/
        resetTokenRepository.delete(tokenRep);

        return true;
    }

    private String createJWToken(String subject, String roles){
        return Jwts.builder().setSubject(subject).claim("roles", roles).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
    }
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
}
