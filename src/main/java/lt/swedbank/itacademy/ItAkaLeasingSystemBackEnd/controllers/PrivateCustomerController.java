package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.errors.ErrorDetails;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.PrivateCustomerResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.PrivateCustomerService;
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
 * Created by Lukas on 2018-03-20.
 */
@RestController
@ControllerAdvice
@CrossOrigin
@RequestMapping(value = "/")
public class PrivateCustomerController extends ResponseEntityExceptionHandler{

    @Autowired
    private PrivateCustomerService privateCustomerService;

    @RequestMapping(value = "/privateCustomers")
    public List<PrivateCustomerResponse> getAllPrivateCustomers(){
        return privateCustomerService.getAllPrivateCustomers();
    }

    @RequestMapping(value = "/privateCustomers/add", method = RequestMethod.POST)
    public PrivateCustomerResponse addPrivateCustomer(@Valid @RequestBody PrivateCustomer privateCustomer){
        return new PrivateCustomerResponse(privateCustomerService.addNewPrivateCustomer(privateCustomer));
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
