package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.PrivateCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * Created by Lukas on 2018-03-20.
 */
@Service
public class PrivateCustomerService {
    @Autowired
    private PrivateCustomerRepository privateCustomerRepository;

    public PrivateCustomer addNewPrivateCustomer(@Valid PrivateCustomer privateCustomer){
        PrivateCustomer newPrivateCustomer = new PrivateCustomer();

        return privateCustomerRepository.save(newPrivateCustomer);
    }
}
