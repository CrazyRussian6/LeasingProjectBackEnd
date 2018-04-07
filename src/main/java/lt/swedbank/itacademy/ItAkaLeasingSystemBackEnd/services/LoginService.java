package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Administrator;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.errors.ErrorDetails;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.Login;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.PasswordRequest;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.AdministratorRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.CustomerRepository;
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
                }
            }
        }
        return null;
    }

    public ResponseEntity<String> administratorLogin(Login login){

        //Add new admin with default credentials
        /*String hashedPass = PasswordEncryption.encrypt(login.getUserId(), login.getPassword());

        Administrator admin = new Administrator();
        admin.setUserID(login.getUserId());
        admin.setPassword(hashedPass);

        administratorRepository.save(admin);*/

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
    }

    public List<VehicleLeasingResponse> changePassword(PasswordRequest passwordRequest) {

        String userId = passwordRequest.getUserId();
        String oldPassword = passwordRequest.getOldPassword();
        String newPassword = passwordRequest.getNewPassword();

        Customer customer = customerRepository.findCustomerByUserID(userId);

        boolean decryptedOldPassLegit = PasswordEncryption.decrypt(userId, oldPassword,
                customerRepository.findCustomerByUserID(userId).getPassword());
        if (!decryptedOldPassLegit) {
            throw new IllegalArgumentException("Specified old password does not equal customer's password");
        } else {

            String encryptedPass = PasswordEncryption.encrypt(userId, newPassword);
            customer.setPassword(encryptedPass);
            //customer.setPassword(passwordRequest.getNewPassword());
            customerRepository.save(customer);

            List<VehicleLeasingResponse> responses = new ArrayList<>();
            for(VehicleLeasing vehicleLeasing : vehicleLeasingRepository
                    .findVehicleLeasingsByCustomerID(customer.getId().toString())){
                responses.add(new VehicleLeasingResponse(vehicleLeasing));
            }

            return responses;
        }
    }

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

        String encryptedPass = PasswordEncryption.encrypt(userId, newPassword);
        customer.setPassword(encryptedPass);
        customerRepository.save(customer);

        return true;
    }
}
