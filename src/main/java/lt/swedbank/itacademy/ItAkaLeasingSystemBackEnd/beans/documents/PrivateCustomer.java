package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity(name = "PrivateCustomer")
//@Table(name = "customers")
@Component
public class PrivateCustomer extends Customer {

    @NotNull(message = "private ID must be specified")
    private String privateID;

    @NotNull(message = "first name must be specified")
    private String firstName;

    @NotNull(message = "last name must be specified")
    private String lastName;

    public String getPrivateID() {
        return privateID;
    }

    public void setPrivateID(String privateID) {
        this.privateID = privateID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
