package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
