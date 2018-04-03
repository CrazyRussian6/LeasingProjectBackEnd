package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@MappedSuperclass
public class Customer {

    @Id
    private ObjectId id;

    @NotNull(message = "email must be specified")
    @Email(message = "email must be correct")
    @Size(max=70, message ="email can't be longer then 70 symbols")
    private String email;

    @NotNull(message = "phoneNumber must be specified")
    //@Size(max=20, message = "phone number can't be longer then 20 symbols")
    @Digits(integer=20, fraction = 0, message = "phone number can't be longer then 20 symbols")
    private BigInteger phoneNumber;

    @NotNull(message = "address must be specified")
    @Size(max=500, message = "address can't be longer then 500 symbols" )
    private String address;

    @NotNull(message = "customer type must be specified")
    private CustomerType customerType;

    @NotNull(message = "customer country must be specified")
    private String country;

    @NotNull(message = "customer user ID must be specified")
    private String userID;

    @NotNull(message = "customer password not set")
    private String password;

    private boolean changedPassword = false;

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

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
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

    public boolean isChangedPassword() {
        return changedPassword;
    }

    public void setChangedPassword(boolean changedPassword) {
        this.changedPassword = changedPassword;
    }
}
