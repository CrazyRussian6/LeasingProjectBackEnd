package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Created by Lukas on 2018-03-20.
 */
public class CustomerResponse extends Response{

    private String id;

    private String email;

    private BigInteger phoneNumber;

    private String address;

    private String customerType;

    private String country;

    private String userID;

   // private String password;

    public CustomerResponse(){

    }

    public CustomerResponse(String id, String email, BigInteger phoneNumber,
                            String address, String customerType, String country,
                            String userID) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.customerType = customerType;
        this.country = country;
        this.userID = userID;
        //this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
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

    /*public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerResponse)) return false;
        CustomerResponse that = (CustomerResponse) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getCustomerType(), that.getCustomerType()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getUserID(), that.getUserID());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getEmail(), getPhoneNumber(), getAddress(), getCustomerType(), getCountry(), getUserID());
    }
}
