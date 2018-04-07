package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;

import java.util.Objects;




/**
 * Created by Lukas on 2018-03-20.
 */
public class BusinessCustomerResponse extends CustomerResponse{

    private String companyID;

    private String companyName;

    public BusinessCustomerResponse() {
    }

    public BusinessCustomerResponse(BusinessCustomer businessCustomer) {
        super(businessCustomer.getId().toString(), businessCustomer.getEmail(),
                businessCustomer.getPhoneNumber(), businessCustomer.getAddress(),
                businessCustomer.getCustomerType().toString(), businessCustomer.getCountry(),
                businessCustomer.getUserID());
        this.companyID = businessCustomer.getCompanyID();
        this.companyName = businessCustomer.getCompanyName();
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
/*<<<<<<< HEAD
=======*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusinessCustomerResponse)) return false;
        if (!super.equals(o)) return false;
        BusinessCustomerResponse that = (BusinessCustomerResponse) o;
        return Objects.equals(getCompanyID(), that.getCompanyID()) &&
                Objects.equals(getCompanyName(), that.getCompanyName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getCompanyID(), getCompanyName());
    }
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
}
