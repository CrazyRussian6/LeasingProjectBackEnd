package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.*;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.errors.ErrorDetails;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.Credentials;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.Login;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.PasswordRequest;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.*;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.CustomerService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.PasswordEncryption;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.UserIDGenerator;
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
            return ifExists;
        }

        String generatedID = UserIDGenerator.generateRandomID(12);
        while(customerService.existsCustomerByUserID(generatedID)){
            generatedID = UserIDGenerator.generateRandomID(12);
        }

        String hashedPass = PasswordEncryption.encrypt(generatedID, generatedID);
        customer.setUserID(generatedID);
        customer.setPassword(hashedPass);
        return new BusinessCustomerResponse(customerService.addNewBusinessCustomer(customer));
    }

    @RequestMapping(value = "/customers/addPrivateCustomer", method = RequestMethod.POST)
    public CustomerResponse addCustomer(@Valid @RequestBody PrivateCustomer customer){
        PrivateCustomerResponse ifExists = customerService.ifExistsPrivateCustomer(customer.getPrivateID(), customer.getFirstName(), customer.getLastName());
        if(ifExists != null){
            return ifExists;
        }

        String generatedID = UserIDGenerator.generateRandomID(12);
        while(customerService.existsCustomerByUserID(generatedID)){
            generatedID = UserIDGenerator.generateRandomID(12);
        }

        String hashedPass = PasswordEncryption.encrypt(generatedID, generatedID);
        customer.setUserID(generatedID);
        customer.setPassword(hashedPass);

        return new PrivateCustomerResponse(customerService.addNewPrivateCustomer(customer));
    }

    @RequestMapping(value = "/customers/login", method = RequestMethod.POST)
    public Object Login(@RequestBody Login loginData){
        return customerService.login(loginData);
    }

    @RequestMapping(value = "/customers/change/password", method = RequestMethod.POST)
    public List<VehicleLeasingResponse> changePassword(@RequestBody PasswordRequest passwordRequest){
        return customerService.changePassword(passwordRequest);
    }

    @RequestMapping(value = "customers/change/forgot", method = RequestMethod.POST)
    public boolean passwordRecovery(@RequestBody PasswordRequest passwordRequest){
        return customerService.passwordRecovery(passwordRequest);
    }

    @RequestMapping(value = "/customers/{userId}", method = RequestMethod.POST)
    public ResponseEntity existsCustomerByID(@PathVariable("userId") String userId){
        boolean exists = customerService.existsCustomerByUserID(userId);
        return exists ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/customers/{email}", method = RequestMethod.GET)
    public ResponseEntity existsCustomerByEmail(@PathVariable("email") String email){
        boolean exists = customerService.existsCustomerByEmail(email);
        return exists ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/customers/check", method = RequestMethod.POST)
    public ResponseEntity<Object> existsCustomerByIdAndEmail(@RequestBody Credentials credentials){
        boolean exists = customerService.existsCustomerByUserIDAndEmail(credentials.getUserId(), credentials.getEmail());
        return exists ? new ResponseEntity<>("User found", HttpStatus.OK) :
                new ResponseEntity<>("No such user found", HttpStatus.NOT_FOUND);
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
