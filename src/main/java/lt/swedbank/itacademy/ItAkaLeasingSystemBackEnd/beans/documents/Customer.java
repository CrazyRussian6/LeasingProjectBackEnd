package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Customer {

    @NotNull(message = "email must be specified")
    @Email(message = "email must be correct")
    private String email;

    @NotNull(message = "phoneNumber must be specified")
    private String phoneNumber;

    @NotNull(message = "address must be specified")
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
