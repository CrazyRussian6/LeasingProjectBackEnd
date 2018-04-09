package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.controllers;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.Login;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.PasswordRequest;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.CustomerService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.LoginService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.LoginCredentials;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front.PasswordRequest;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response.VehicleLeasingResponse;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.services.LoginService;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = EndPoints.CUSTOMERS_LOGIN, method = RequestMethod.POST)
    public String Login(@RequestBody LoginCredentials loginData){
        return loginService.login(loginData);
    }

    @RequestMapping(value = EndPoints.OFFICER_LOGIN, method = RequestMethod.POST)
    public Object OfficerLogin(@RequestBody LoginCredentials loginData){
        return loginService.administratorLogin(loginData);
    }

    @RequestMapping(value = EndPoints.CUSTOMERS_CHANGE_PASSWORD, method = RequestMethod.POST)
    public List<VehicleLeasingResponse> changePassword(@RequestBody PasswordRequest passwordRequest){
        return loginService.changePassword(passwordRequest);
    }

    @RequestMapping(value = EndPoints.CUSTOMERS_CHANGE_FORGOT, method = RequestMethod.POST)
    public boolean passwordRecovery(@RequestBody PasswordRequest passwordRequest){
        return loginService.passwordRecovery(passwordRequest);
    }
}
