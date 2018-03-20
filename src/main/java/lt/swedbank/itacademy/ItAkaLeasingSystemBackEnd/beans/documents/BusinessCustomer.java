package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class BusinessCustomer extends Customer {

    @Id
    private String companyID;

    @NotNull
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
