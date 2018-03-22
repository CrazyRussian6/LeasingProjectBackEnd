package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PrivateCustomer extends Customer {

    @Id
    private ObjectId id;

    @NotNull(message = "private ID must be specified")
    @Size(min = 11, max = 11, message = "private ID must be 11 symbols length")
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
