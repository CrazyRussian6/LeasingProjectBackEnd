package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.Login;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.PasswordRequest;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/customers/login", method = RequestMethod.POST)
    public Object Login(@RequestBody Login loginData){
        return loginService.login(loginData);
    }

    @RequestMapping(value = "/officer/login", method = RequestMethod.POST)
    public Object OfficerLogin(@RequestBody Login loginData){
        return loginService.administratorLogin(loginData);
    }

    @RequestMapping(value = "/customers/change/password", method = RequestMethod.POST)
    public List<VehicleLeasingResponse> changePassword(@RequestBody PasswordRequest passwordRequest){
        return loginService.changePassword(passwordRequest);
    }

    @RequestMapping(value = "customers/change/forgot", method = RequestMethod.POST)
    public boolean passwordRecovery(@RequestBody PasswordRequest passwordRequest){
        return loginService.passwordRecovery(passwordRequest);
    }
}
