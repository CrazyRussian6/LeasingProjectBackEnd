package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Customer {

    @Id
    private ObjectId id;

    @NotNull(message = "email must be specified")
    @Email(message = "email must be correct")
    private String email;

    @NotNull(message = "phoneNumber must be specified")
    private String phoneNumber;

    @NotNull(message = "address must be specified")
    private String address;

    @NotNull(message = "customer type must be specified")
    private CustomerType customerType;

    //@NotNull(message = "customer country must be specified")
    private String country;

    //@NotNull(message = "customer user ID must be specified")
    private String userID;

    private String password;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
