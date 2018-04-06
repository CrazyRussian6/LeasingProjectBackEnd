package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.Valid;
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

    /*public BusinessCustomer() {
    }

    public BusinessCustomer(@Valid BusinessCustomer businessCustomer){
        this.setId(businessCustomer.getId());
        this.setCompanyID(businessCustomer.getCompanyID());
        this.setCompanyName(businessCustomer.getCompanyName());
        this.setAddress(businessCustomer.getAddress());
        this.setEmail(businessCustomer.getEmail());
        this.setPhoneNumber(businessCustomer.getPhoneNumber());
        this.setCustomerType(businessCustomer.getCustomerType());
        this.setCountry(businessCustomer.getCountry());
        this.setUserID(businessCustomer.getUserID());
        this.setPassword(businessCustomer.getPassword());
        this.setChangedPassword(businessCustomer.isChangedPassword());
    }*/

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
