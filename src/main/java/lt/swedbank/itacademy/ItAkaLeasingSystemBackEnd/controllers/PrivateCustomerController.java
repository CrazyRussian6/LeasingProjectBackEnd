/*package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.PrivateCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.PrivateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@ControllerAdvice
@CrossOrigin
//@RequestMapping(value = "/")
public class PrivateCustomerController{

    @Autowired
    private PrivateCustomerService privateCustomerService;

    //@RequestMapping(value = "/privateCustomers")
    public List<PrivateCustomerResponse> getAllPrivateCustomers(){
        return privateCustomerService.getAllPrivateCustomers();
    }

    //@RequestMapping(value = "/privateCustomers/add", method = RequestMethod.POST)
    public PrivateCustomerResponse addPrivateCustomer(@Valid @RequestBody PrivateCustomer privateCustomer){
        return new PrivateCustomerResponse(privateCustomerService.addNewPrivateCustomer(privateCustomer));
    }
}
*/