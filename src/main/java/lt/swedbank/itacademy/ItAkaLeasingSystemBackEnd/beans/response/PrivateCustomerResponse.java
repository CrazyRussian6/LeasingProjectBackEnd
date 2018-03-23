package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;

/**
 * Created by Lukas on 2018-03-20.
 */
public class PrivateCustomerResponse extends CustomerResponse {

    private String privateID;

    private String firstName;

    private String lastName;

    private String id;

    public PrivateCustomerResponse(){

    }

    public PrivateCustomerResponse(PrivateCustomer privateCustomer) {
        super(privateCustomer.getEmail(), privateCustomer.getPhoneNumber(), privateCustomer.getAddress());
        this.id = privateCustomer.getId().toString();
        this.privateID = privateCustomer.getPrivateID();
        this.firstName = privateCustomer.getFirstName();
        this.lastName = privateCustomer.getLastName();
    }

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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
