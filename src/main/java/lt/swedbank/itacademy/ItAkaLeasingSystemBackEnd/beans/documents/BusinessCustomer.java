package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.CustomerType;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Objects;

@Entity(name = "BusinessCustomer")
//@Table(name = "customers")
@Component
public class BusinessCustomer extends Customer {

    @NotNull(message = "company ID must be specified")
    @Size(max=20, message = "company ID can't be longer then 20 symbols")
    private String companyID;

    @NotNull(message = "company name must be specified")
    @Size(max=100, message= "company name can't be longer then 100 symbols")
    private String companyName;

    public BusinessCustomer() {
    }


    public BusinessCustomer(ObjectId id, String email, BigInteger phoneNumber, String address,
                            CustomerType customerType, String country, String userID, String password,
                            boolean changedPassword, String companyID, String companyName) {
        super(id, email, phoneNumber, address, customerType, country, userID, password, changedPassword);
        this.companyID = companyID;
        this.companyName = companyName;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusinessCustomer)) return false;
        if (!super.equals(o)) return false;
        BusinessCustomer that = (BusinessCustomer) o;
        return Objects.equals(getCompanyID(), that.getCompanyID()) &&
                Objects.equals(getCompanyName(), that.getCompanyName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getCompanyID(), getCompanyName());
    }
}
