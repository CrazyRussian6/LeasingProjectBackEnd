package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.PrivateCustomer;

/*<<<<<<< HEAD
=======*/
import java.util.Objects;

//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
/**
 * Created by Lukas on 2018-03-20.
 */
public class PrivateCustomerResponse extends CustomerResponse {

    private String privateID;

    private String firstName;

    private String lastName;

    public PrivateCustomerResponse(){

    }

    public PrivateCustomerResponse(PrivateCustomer privateCustomer) {
        super(privateCustomer.getId().toString(), privateCustomer.getEmail(),
                privateCustomer.getPhoneNumber(), privateCustomer.getAddress(),
                privateCustomer.getCustomerType().toString(), privateCustomer.getCountry(),
                privateCustomer.getUserID());
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
/*<<<<<<< HEAD
=======*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrivateCustomerResponse)) return false;
        if (!super.equals(o)) return false;
        PrivateCustomerResponse that = (PrivateCustomerResponse) o;
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
