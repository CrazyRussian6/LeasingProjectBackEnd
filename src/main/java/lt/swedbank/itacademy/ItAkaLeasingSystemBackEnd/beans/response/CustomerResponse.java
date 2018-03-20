package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import javax.validation.constraints.NotNull;

/**
 * Created by Lukas on 2018-03-20.
 */
public abstract class CustomerResponse extends Response{
    private String email;

    private String phoneNumber;

    private String adress;

    public CustomerResponse(){

    }

    public CustomerResponse(String email, String phoneNumber, String adress) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
