package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

//<<<<<<< HEAD
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

//=======
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.EmailService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
@RestController
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;

/*<<<<<<< HEAD
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ResetTokenService resetTokenService;

    @RequestMapping(value="customers/forgotpassword{email}", method = RequestMethod.POST)
    public ResponseEntity<String> forgotPassword(@PathVariable("email") String email, HttpServletRequest request){
        Customer customer = customerService.findCustomerByEmail(email);
        if(customer == null){
            return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
        }
        else{
            PasswordResetToken tokenCheck = resetTokenService.findByCustomerID(customer.getUserID());
            if(tokenCheck != null){
                System.out.println("Token exists in db");
                if(!emailService.validTimePassed(tokenCheck, 10)){
                    System.out.println("10 MINUTES HAVEN'T PASSED!");
                    return new ResponseEntity<>("10 MINUTES HAVEN'T PASSED", HttpStatus.FORBIDDEN);
                }
                else{
                    resetTokenService.deleteByToken(tokenCheck.getToken());
                }
            }

            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.HOUR_OF_DAY, 24);

            PasswordResetToken token = new PasswordResetToken(customer.getUserID(), UUID.randomUUID().toString(), cal.getTime(), new Date());

            String recoveryUrl = "http://localhost:4200/new-pass?token=" + token.getToken();

            System.out.println(recoveryUrl);

            SimpleMailMessage recoveryMessage = new SimpleMailMessage();
            recoveryMessage.setFrom("leasingservicemail@gmail.com");
            recoveryMessage.setTo(email);
            recoveryMessage.setSubject("Password reset request");
            recoveryMessage.setText("To reset your password, click the link below:\n" + recoveryUrl);

            //emailService.sendEmail(recoveryMessage);
            resetTokenService.addToken(token);

            return new ResponseEntity<>("Password request successful", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "customers/resetpasswordval", method = RequestMethod.GET)
    public ResponseEntity<String> resetPassword(@RequestParam("token") String token){
        PasswordResetToken resetToken = resetTokenService.findByToken(token);

        if(resetToken == null){
            return new ResponseEntity<>("Bad link", HttpStatus.NOT_FOUND);
        }
        else{
            //TODO: validate token properly
            String tokenStatus = PasswordResetTokenUtils.validate(resetToken);

            if(tokenStatus.equals("valid")){
                return new ResponseEntity<>("Valid", HttpStatus.OK);
            }
            else if(tokenStatus.equals("expired")){
                resetTokenService.deleteByToken(token);
                return new ResponseEntity<>("Expired link", HttpStatus.GONE);
            }
            return new ResponseEntity<>("Invalid token", HttpStatus.BAD_REQUEST);
        }
=======*/
    @RequestMapping(value= EndPoints.CUSTOMERS_FORGOTPASSWORD_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<String> forgotPassword(@PathVariable("email") String email){
        return emailService.forgotPassword(email);
    }

    @RequestMapping(value = EndPoints.CUSTOMERS_RESETPASSWORDVAL, method = RequestMethod.GET)
    public ResponseEntity<String> resetPassword(@RequestParam("token") String token){
        return emailService.resetPassword(token);
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    }
}
