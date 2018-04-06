package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "PrivateCustomer")
//@Table(name = "customers")
@Component
public class PrivateCustomer extends Customer {

    @NotNull(message = "private ID must be specified")
    @Size(max=20, message= "private id must can be maximum 20 symbols length")
    @Pattern(regexp = "^[0-9]*$", message = "private id can not have characters")
    private String privateID;

    @NotNull(message = "first name must be specified")
    @Size(min=2, max=100, message = "first name must be shorter then 100 symbols")
    private String firstName;

    @NotNull(message = "last name must be specified")
    @Size(min=2, max=100, message="last name must be shorter then 100 symbols")
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
