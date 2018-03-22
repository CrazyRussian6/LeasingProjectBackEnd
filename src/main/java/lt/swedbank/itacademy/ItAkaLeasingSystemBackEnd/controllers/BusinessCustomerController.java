package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.BusinessCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.BusinessCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Lukas on 2018-03-20.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class BusinessCustomerController {

    @Autowired
    private BusinessCustomerService businessCustomerService;

    @RequestMapping(value = "/businessCustomers")
    public List<BusinessCustomerResponse> getAllBusinessCustomers(){
        return businessCustomerService.getAllBusinessCustomers();
    }

    @RequestMapping(value = "/businessCustomers/add", method = RequestMethod.POST)
    public BusinessCustomerResponse addBusinessCustomer(@Valid @RequestBody BusinessCustomer businessCustomer){
        return new BusinessCustomerResponse(businessCustomerService.addNewBusinessCustomer(businessCustomer));
    }
}
