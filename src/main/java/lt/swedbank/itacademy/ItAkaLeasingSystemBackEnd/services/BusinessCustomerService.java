package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.BusinessCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.BusinessCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukas on 2018-03-20.
 */
@Service
public class BusinessCustomerService {

    @Autowired
    private BusinessCustomerRepository businessCustomerRepository;

    public List<BusinessCustomerResponse> getAllBusinessCustomers(){
        List<BusinessCustomerResponse> responses = new ArrayList<>();
        for(BusinessCustomer businessCustomer : businessCustomerRepository.findAll()){
            responses.add(new BusinessCustomerResponse(businessCustomer));
        }
        return responses;
    }

    public BusinessCustomer addNewBusinessCustomer(@Valid BusinessCustomer businessCustomer){
        BusinessCustomer newBusinessCustomer = new BusinessCustomer();

        newBusinessCustomer.setCompanyID(businessCustomer.getCompanyID());
        newBusinessCustomer.setCompanyName(businessCustomer.getCompanyName());
        newBusinessCustomer.setAddress(businessCustomer.getAddress());
        newBusinessCustomer.setEmail(businessCustomer.getEmail());
        newBusinessCustomer.setPhoneNumber(businessCustomer.getPhoneNumber());

        return businessCustomerRepository.save(newBusinessCustomer);
    }
}
