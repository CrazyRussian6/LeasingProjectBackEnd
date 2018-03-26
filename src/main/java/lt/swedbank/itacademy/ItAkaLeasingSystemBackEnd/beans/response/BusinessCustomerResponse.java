package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;

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
                businessCustomer.getPhoneNumber(), businessCustomer.getAddress(), businessCustomer.getCustomerType().toString());
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
}
