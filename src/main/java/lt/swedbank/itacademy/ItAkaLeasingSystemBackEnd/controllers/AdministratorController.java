package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.CustomerLoans;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.AdministratorService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
@CrossOrigin
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @RequestMapping(value = EndPoints.OFFICER_LOANS, method = RequestMethod.GET)
    public List<CustomerLoans> getAllCustomerLoans(){
        return administratorService.getCustomerLoans();
    }
}
