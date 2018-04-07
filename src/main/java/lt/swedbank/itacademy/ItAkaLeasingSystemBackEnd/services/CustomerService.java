package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

//<<<<<<< HEAD
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
//=======
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.BusinessCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.CustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.PrivateCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.CustomerRepository;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.PasswordEncryption;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.UserIDGenerator;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6

/**
 * @author Lukas
 */
/*@Service
<<<<<<< HEAD
public class CustomerService {
=======*/
@Service
public class CustomerService {
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private VehicleLeasingRepository vehicleLeasingRepository;
/*
=======*/
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    public boolean existsCustomerByUserID(String userID) {
        return customerRepository.existsCustomerByUserID(userID);
    }

    public boolean existsCustomerByEmail(String email){
        return customerRepository.existsCustomerByEmail(email);
    }

    public boolean existsCustomerByUserIDAndEmail(String userID, String email){
        return customerRepository.existsCustomerByUserIDAndEmail(userID, email);
    }

    public Customer findCustomerByEmail(String email){
/*<<<<<<< HEAD
        return customerRepository.findCustomerByEmail(email);
=======*/
        return customerRepository.findCustomerByEmail(email).orElse(null);
    }

    public Customer findCustomerByUserID(String userID){
        return customerRepository.findCustomerByUserID(userID).orElse(null);
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
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


/*<<<<<<< HEAD
    public BusinessCustomerResponse ifExistsBusinessCustomer(String companyID, String companyName) {
=======*/
    public BusinessCustomer ifExistsBusinessCustomer(String companyID, String companyName) {
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
        List<Customer> businessCustomers = customerRepository.findCustomersByCustomerType(CustomerType.BUSINESS);
        for (Customer customer : businessCustomers) {
            BusinessCustomer temp = (BusinessCustomer) customer;
            if (temp.getCompanyID().equals(companyID) && temp.getCompanyName().equals(companyName)) {
/*<<<<<<< HEAD
                return new BusinessCustomerResponse(temp);
=======*/
                return temp;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
            }
        }
        return null;
    }

/*<<<<<<< HEAD
    public PrivateCustomerResponse ifExistsPrivateCustomer(String privateID, String firstName, String lastName) {
=======*/
    public PrivateCustomer ifExistsPrivateCustomer(String privateID, String firstName, String lastName) {
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
        List<Customer> privateCustomers = customerRepository.findCustomersByCustomerType(CustomerType.PRIVATE);
        for (Customer customer : privateCustomers) {
            PrivateCustomer temp = (PrivateCustomer) customer;
            if (temp.getPrivateID().equals(privateID) && temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName)) {
/*<<<<<<< HEAD
                return new PrivateCustomerResponse(temp);
=======*/
                return temp;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
            }
        }
        return null;
    }

    public BusinessCustomer addNewBusinessCustomer(@Valid BusinessCustomer businessCustomer) {
/*<<<<<<< HEAD
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
=======*/
        BusinessCustomer ifExists = ifExistsBusinessCustomer(businessCustomer.getCompanyID(),
                businessCustomer.getCompanyName());

        if(ifExists != null){
            return ifExists;
        }

        String generatedID = UserIDGenerator.generateRandomID(12);
        while(existsCustomerByUserID(generatedID)){
            generatedID = UserIDGenerator.generateRandomID(12);
        }

        String hashedPass = PasswordEncryption.encrypt(generatedID, generatedID);
        businessCustomer.setUserID(generatedID);
        businessCustomer.setPassword(hashedPass);
        return customerRepository.save(businessCustomer);
    }

    public PrivateCustomer addNewPrivateCustomer(@Valid PrivateCustomer privateCustomer) {
        PrivateCustomer ifExists = ifExistsPrivateCustomer(privateCustomer.getPrivateID(),
                                                                   privateCustomer.getFirstName(),
                                                                   privateCustomer.getLastName());
        if(ifExists != null){
            return ifExists;
        }

        String generatedID = UserIDGenerator.generateRandomID(12);
        while(existsCustomerByUserID(generatedID)){
            generatedID = UserIDGenerator.generateRandomID(12);
        }

        String hashedPass = PasswordEncryption.encrypt(generatedID, generatedID);
        privateCustomer.setUserID(generatedID);
        privateCustomer.setPassword(hashedPass);
        return customerRepository.save(privateCustomer);
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    }
}
