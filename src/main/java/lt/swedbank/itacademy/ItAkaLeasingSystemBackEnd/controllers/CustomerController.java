package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Login;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.errors.ErrorDetails;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.BusinessCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.CustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.PrivateCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Lukas
 */
@RestController
@ControllerAdvice
@CrossOrigin
@RequestMapping(value = "/")
public class CustomerController extends ResponseEntityExceptionHandler {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers")
    public List<CustomerResponse> getAllCustomers(){
        return customerService.getAllCustomers();
    }


    @RequestMapping(value = "/customers/addBusinessCustomer", method = RequestMethod.POST)
    public BusinessCustomerResponse addCustomer(@Valid @RequestBody BusinessCustomer customer){
        BusinessCustomerResponse ifExists = customerService.ifExistsBusinessCustomer(customer.getCompanyID(), customer.getCompanyName());
        if(ifExists != null){
            System.out.println("BusinessCustomer exists");
            return ifExists;
        }

        return new BusinessCustomerResponse(customerService.addNewBusinessCustomer(customer));
    }

    @RequestMapping(value = "/customers/login", method = RequestMethod.POST)
    public Object Login(@RequestBody Login loginData){
        return customerService.login(loginData);
    }

    @RequestMapping(value = "/customers/addPrivateCustomer", method = RequestMethod.POST)
    public CustomerResponse addCustomer(@Valid @RequestBody PrivateCustomer customer){
        PrivateCustomerResponse ifExists = customerService.ifExistsPrivateCustomer(customer.getPrivateID(), customer.getFirstName(), customer.getLastName());
        if(ifExists != null){
            System.out.println("PrivateCustomer exists");
            return ifExists;
        }
        return new PrivateCustomerResponse(customerService.addNewPrivateCustomer(customer));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> errorMessages = new ArrayList<>();
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errorMessages.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ErrorDetails errorDetails = new ErrorDetails(dateFormat.format(new Date()), "Validation failure", errorMessages);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
