package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas
 */
@Service
public class CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

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
        return customerRepository.findCustomerByEmail(email).orElse(null);
    }

    public Customer findCustomerByUserID(String userID){
        return customerRepository.findCustomerByUserID(userID).orElse(null);
    }

    public Customer findCustomerByEmailAndID(String email, String id){
        return customerRepository.findCustomerByUserIDAndEmail(id, email).orElse(null);
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


    public BusinessCustomer ifExistsBusinessCustomer(String companyID, String companyName) {
        List<Customer> businessCustomers = customerRepository.findCustomersByCustomerType(CustomerType.BUSINESS);
        for (Customer customer : businessCustomers) {
            BusinessCustomer temp = (BusinessCustomer) customer;
            if (temp.getCompanyID().equals(companyID) && temp.getCompanyName().equals(companyName)) {
                return temp;
            }
        }
        return null;
    }

    public PrivateCustomer ifExistsPrivateCustomer(String privateID, String firstName, String lastName) {
        List<Customer> privateCustomers = customerRepository.findCustomersByCustomerType(CustomerType.PRIVATE);
        for (Customer customer : privateCustomers) {
            PrivateCustomer temp = (PrivateCustomer) customer;
            if (temp.getPrivateID().equals(privateID) && temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName)) {
                return temp;
            }
        }
        return null;
    }

    public BusinessCustomer addNewBusinessCustomer(@Valid BusinessCustomer businessCustomer) {
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
    }
}
