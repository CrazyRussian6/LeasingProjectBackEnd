package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class BusinessCustomer extends Customer {

    @Id
    private ObjectId id;

    @NotNull(message = "company ID must be specified")
    private String companyID;

    @NotNull(message = "company name must be specified")
    private String companyName;

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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
