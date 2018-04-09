package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;


import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.tokens.PasswordResetToken;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.CustomerService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.EmailService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.ResetTokenService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.PasswordResetTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;


import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.EmailCredentials;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.LoginCredentials;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.EmailService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value= EndPoints.CUSTOMERS_FORGOTPASSWORD_CREDS, method = RequestMethod.POST)
    public ResponseEntity<String> forgotPassword(@RequestBody EmailCredentials creds){
        return emailService.forgotPassword(creds);
    }

    @RequestMapping(value = EndPoints.CUSTOMERS_RESETPASSWORDVAL, method = RequestMethod.GET)
    public ResponseEntity<String> resetPassword(@RequestParam("token") String token){
        return emailService.resetPassword(token);
    }
}
