package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.BusinessCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * Created by Lukas on 2018-03-20.
 */
@Service
public class BusinessCustomerService {

    @Autowired
    private BusinessCustomerRepository businessCustomerRepository;

    public BusinessCustomer addNewBusinessCustomer(@Valid BusinessCustomer businessCustomer){
        BusinessCustomer newBusinessCustomer = new BusinessCustomer();

        businessCustomerRepository.save(newBusinessCustomer);
    }
}
