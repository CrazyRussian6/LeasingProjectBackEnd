package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

/**
 * Created by Lukas on 2018-03-20.
 */
public class CustomerResponse extends Response{

    private String id;

    private String email;

    private String phoneNumber;

    private String adress;

    private String customerType;

    private String country;

    public CustomerResponse(){

    }

    public CustomerResponse(String id, String email, String phoneNumber,
                            String adress, String customerType, String country) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.customerType = customerType;
        this.country = country;
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
}
