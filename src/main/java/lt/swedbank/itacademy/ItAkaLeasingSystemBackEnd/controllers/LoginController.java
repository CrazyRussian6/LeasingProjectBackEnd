package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

//<<<<<<< HEAD
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.Login;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.PasswordRequest;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.CustomerService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.LoginService;
//=======
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.LoginCredentials;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.PasswordRequest;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.LoginService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.EndPoints;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

/*<<<<<<< HEAD
    @RequestMapping(value = "/customers/login", method = RequestMethod.POST)
    public Object Login(@RequestBody Login loginData){
        return loginService.login(loginData);
    }

    @RequestMapping(value = "/customers/change/password", method = RequestMethod.POST)
=======*/
    @RequestMapping(value = EndPoints.CUSTOMERS_LOGIN, method = RequestMethod.POST)
    public String Login(@RequestBody LoginCredentials loginData){
        return loginService.login(loginData);
    }

    @RequestMapping(value = EndPoints.OFFICER_LOGIN, method = RequestMethod.POST)
    public Object OfficerLogin(@RequestBody LoginCredentials loginData){
        return loginService.administratorLogin(loginData);
    }

    @RequestMapping(value = EndPoints.CUSTOMERS_CHANGE_PASSWORD, method = RequestMethod.POST)
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    public List<VehicleLeasingResponse> changePassword(@RequestBody PasswordRequest passwordRequest){
        return loginService.changePassword(passwordRequest);
    }

/*<<<<<<< HEAD
    @RequestMapping(value = "customers/change/forgot", method = RequestMethod.POST)
=======*/
    @RequestMapping(value = EndPoints.CUSTOMERS_CHANGE_FORGOT, method = RequestMethod.POST)
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    public boolean passwordRecovery(@RequestBody PasswordRequest passwordRequest){
        return loginService.passwordRecovery(passwordRequest);
    }
}
