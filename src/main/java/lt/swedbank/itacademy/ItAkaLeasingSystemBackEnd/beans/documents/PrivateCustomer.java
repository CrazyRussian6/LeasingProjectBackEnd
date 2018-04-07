package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

/*<<<<<<< HEAD
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
=======*/
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.util.Objects;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6

@Entity(name = "PrivateCustomer")
//@Table(name = "customers")
@Component
public class PrivateCustomer extends Customer {

    @NotNull(message = "private ID must be specified")
    @Size(max=20, message= "private id must can be maximum 20 symbols length")
/*<<<<<<< HEAD
=======*/
    @Pattern(regexp = "^[0-9]*$", message = "private id can not have characters")
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
    private String privateID;

    @NotNull(message = "first name must be specified")
    @Size(min=2, max=100, message = "first name must be shorter then 100 symbols")
    private String firstName;

    @NotNull(message = "last name must be specified")
    @Size(min=2, max=100, message="last name must be shorter then 100 symbols")
    private String lastName;

/*<<<<<<< HEAD
=======*/
    public PrivateCustomer() {
    }

    public PrivateCustomer(ObjectId id, String email, BigInteger phoneNumber, String address, CustomerType customerType,
                           String country, String userID, String password, boolean changedPassword, String privateID,
                           String firstName, String lastName) {
        super(id, email, phoneNumber, address, customerType, country, userID, password, changedPassword);
        this.privateID = privateID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
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
/*<<<<<<< HEAD
=======*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrivateCustomer)) return false;
        if (!super.equals(o)) return false;
        PrivateCustomer that = (PrivateCustomer) o;
        return Objects.equals(getPrivateID(), that.getPrivateID()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getPrivateID(), getFirstName(), getLastName());
    }
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
}
