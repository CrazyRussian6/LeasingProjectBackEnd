package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.BusinessCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.PrivateCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.BusinessCustomerService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.PrivateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Lukas on 2018-03-20.
 */
@RestController
@CrossOrigin
public class PrivateCustomerController {

    @Autowired
    private PrivateCustomerService privateCustomerService;

    //@RequestMapping("")
    public List<PrivateCustomerResponse> getAllPrivateCustomers(){
        return privateCustomerService.getAllPrivateCustomers();
    }

    //@RequestMapping("")
    public PrivateCustomerResponse addPrivateCustomer(@Valid @RequestBody PrivateCustomer privateCustomer){
        return new PrivateCustomerResponse(privateCustomerService.addNewPrivateCustomer(privateCustomer));
    }
}
