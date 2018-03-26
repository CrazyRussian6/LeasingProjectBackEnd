package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity(name = "BusinessCustomer")
//@Table(name = "customers")
@Component
public class BusinessCustomer extends Customer {

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
}
