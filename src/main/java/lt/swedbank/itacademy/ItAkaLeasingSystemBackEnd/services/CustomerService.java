package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.BusinessCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.CustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.PrivateCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.CustomerRepository;
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

    public List<CustomerResponse> getAllCustomers(){
        List<CustomerResponse> responses = new ArrayList<>();

        for(Customer customer: customerRepository.findAll()){
            if(customer.getCustomerType().equals(CustomerType.BUSINESS)){
                responses.add(new BusinessCustomerResponse((BusinessCustomer) customer));
            }
            else if(customer.getCustomerType().equals(CustomerType.PRIVATE)){
                responses.add(new PrivateCustomerResponse((PrivateCustomer) customer));
            }
        }
        return responses;
    }

    public BusinessCustomerResponse ifExistsBusinessCustomer(String companyID, String companyName){
        List<Customer> businessCustomers = customerRepository.findCustomersByCustomerType(CustomerType.BUSINESS);
        for(Customer customer : businessCustomers){
            BusinessCustomer temp = (BusinessCustomer)customer;
            if(temp.getCompanyID().equals(companyID) && temp.getCompanyName().equals(companyName)){
                return new BusinessCustomerResponse(temp);
            }
        }
        return null;
    }

    public PrivateCustomerResponse ifExistsPrivateCustomer(String privateID, String firstName, String lastName){
        List<Customer> privateCustomers = customerRepository.findCustomersByCustomerType(CustomerType.PRIVATE);
        for(Customer customer : privateCustomers){
            PrivateCustomer temp = (PrivateCustomer) customer;
            if(temp.getPrivateID().equals(privateID) && temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName)){
                return new PrivateCustomerResponse(temp);
            }
        }
        return null;
    }

    public BusinessCustomer addNewBusinessCustomer(@Valid BusinessCustomer businessCustomer){
        BusinessCustomer newBusinessCustomer = new BusinessCustomer();

        newBusinessCustomer.setId(businessCustomer.getId());
        newBusinessCustomer.setCompanyID(businessCustomer.getCompanyID());
        newBusinessCustomer.setCompanyName(businessCustomer.getCompanyName());
        newBusinessCustomer.setAddress(businessCustomer.getAddress());
        newBusinessCustomer.setEmail(businessCustomer.getEmail());
        newBusinessCustomer.setPhoneNumber(businessCustomer.getPhoneNumber());
        newBusinessCustomer.setCustomerType(businessCustomer.getCustomerType());
        newBusinessCustomer.setCountry(businessCustomer.getCountry());

        return customerRepository.save(newBusinessCustomer);
    }

    public PrivateCustomer addNewPrivateCustomer(@Valid PrivateCustomer privateCustomer){
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

        return customerRepository.save(newPrivateCustomer);
    }
}
