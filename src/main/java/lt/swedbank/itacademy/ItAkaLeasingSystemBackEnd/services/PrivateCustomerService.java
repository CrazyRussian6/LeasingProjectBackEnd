package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.BusinessCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.PrivateCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.repositories.PrivateCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukas on 2018-03-20.
 */
@Service
public class PrivateCustomerService {
    @Autowired
    private PrivateCustomerRepository privateCustomerRepository;

    public PrivateCustomer addNewPrivateCustomer(@Valid PrivateCustomer privateCustomer){
        PrivateCustomer newPrivateCustomer = new PrivateCustomer();

        newPrivateCustomer.setFirstName(privateCustomer.getFirstName());
        newPrivateCustomer.setLastName(privateCustomer.getLastName());
        newPrivateCustomer.setPrivateID(privateCustomer.getPrivateID());
        newPrivateCustomer.setAdress(privateCustomer.getAdress());
        newPrivateCustomer.setEmail(privateCustomer.getEmail());
        newPrivateCustomer.setPhoneNumber(privateCustomer.getPhoneNumber());

        return privateCustomerRepository.save(newPrivateCustomer);
    }

    public List<PrivateCustomerResponse> getAllPrivateCustomers(){
        List<PrivateCustomerResponse> responses = new ArrayList<>();
        for(PrivateCustomer privateCustomer : privateCustomerRepository.findAll()){
            responses.add(new PrivateCustomerResponse(privateCustomer));
        }
        return responses;
    }
}
