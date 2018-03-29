package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.*;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.errors.ErrorDetails;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.Login;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.PasswordRequest;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.*;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.CustomerRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.VehicleLeasingRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleLeasingRepository vehicleLeasingRepository;

    public Object login(Login login) {
        List<Customer> customers = new ArrayList<>(customerRepository.findAll());
        List<String> errorMessage = new ArrayList<>();
        ErrorDetails loginError = new ErrorDetails("LoginError", "LoginError", errorMessage);
        for (Customer user : customers) {

            boolean decrypted = PasswordEncryption.decrypt(login.getUserId(), login.getPassword(),
                    customerRepository.findCustomerByUserID(login.getUserId()).getPassword());

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
                    //return user;
                }

            }
        }
        return null;
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

    public boolean existsCustomerByUserID(String userID) {
        return customerRepository.existsCustomerByUserID(userID);
    }

    public boolean existsCustomerByUserIDAndEmail(String userID, String email){
        return customerRepository.existsCustomerByUserIDAndEmail(userID, email);
    }

    public List<CustomerResponse> getAllCustomers() {
        List<CustomerResponse> responses = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            if (customer.getCustomerType().equals(CustomerType.BUSINESS)) {
                responses.add(new BusinessCustomerResponse((BusinessCustomer) customer));
            } else if (customer.getCustomerType().equals(CustomerType.PRIVATE)) {
                responses.add(new PrivateCustomerResponse((PrivateCustomer) customer));
            }
        }
        return responses;
    }


    public BusinessCustomerResponse ifExistsBusinessCustomer(String companyID, String companyName) {
        List<Customer> businessCustomers = customerRepository.findCustomersByCustomerType(CustomerType.BUSINESS);
        for (Customer customer : businessCustomers) {
            BusinessCustomer temp = (BusinessCustomer) customer;
            if (temp.getCompanyID().equals(companyID) && temp.getCompanyName().equals(companyName)) {
                return new BusinessCustomerResponse(temp);
            }
        }
        return null;
    }

    public PrivateCustomerResponse ifExistsPrivateCustomer(String privateID, String firstName, String lastName) {
        List<Customer> privateCustomers = customerRepository.findCustomersByCustomerType(CustomerType.PRIVATE);
        for (Customer customer : privateCustomers) {
            PrivateCustomer temp = (PrivateCustomer) customer;
            if (temp.getPrivateID().equals(privateID) && temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName)) {
                return new PrivateCustomerResponse(temp);
            }
        }
        return null;
    }

    public BusinessCustomer addNewBusinessCustomer(@Valid BusinessCustomer businessCustomer) {
        BusinessCustomer newBusinessCustomer = new BusinessCustomer();

        newBusinessCustomer.setId(businessCustomer.getId());
        newBusinessCustomer.setCompanyID(businessCustomer.getCompanyID());
        newBusinessCustomer.setCompanyName(businessCustomer.getCompanyName());
        newBusinessCustomer.setAddress(businessCustomer.getAddress());
        newBusinessCustomer.setEmail(businessCustomer.getEmail());
        newBusinessCustomer.setPhoneNumber(businessCustomer.getPhoneNumber());
        newBusinessCustomer.setCustomerType(businessCustomer.getCustomerType());
        newBusinessCustomer.setCountry(businessCustomer.getCountry());
        newBusinessCustomer.setUserID(businessCustomer.getUserID());
        newBusinessCustomer.setPassword(businessCustomer.getPassword());

        return customerRepository.save(newBusinessCustomer);
    }

    public PrivateCustomer addNewPrivateCustomer(@Valid PrivateCustomer privateCustomer) {
        PrivateCustomer newPrivateCustomer = new PrivateCustomer();

        newPrivateCustomer.setId(privateCustomer.getId());
        newPrivateCustomer.setFirstName(privateCustomer.getFirstName());
        newPrivateCustomer.setLastName(privateCustomer.getLastName());
        newPrivateCustomer.setPrivateID(privateCustomer.getPrivateID());
        newPrivateCustomer.setAddress(privateCustomer.getAddress());
        newPrivateCustomer.setEmail(privateCustomer.getEmail());
        newPrivateCustomer.setPhoneNumber(privateCustomer.getPhoneNumber());
        newPrivateCustomer.setCustomerType(privateCustomer.getCustomerType());
        newPrivateCustomer.setCountry(privateCustomer.getCountry());
        newPrivateCustomer.setUserID(privateCustomer.getUserID());
        newPrivateCustomer.setPassword(privateCustomer.getPassword());

        return customerRepository.save(newPrivateCustomer);
    }
}
