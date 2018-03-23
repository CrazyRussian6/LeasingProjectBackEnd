package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.BusinessCustomer;

/**
 * Created by Lukas on 2018-03-20.
 */
public class BusinessCustomerResponse extends CustomerResponse{

    private String companyID;

    private String companyName;

    private String id;

    public BusinessCustomerResponse() {
    }

    public BusinessCustomerResponse(BusinessCustomer businessCustomer) {
        super(businessCustomer.getEmail(), businessCustomer.getPhoneNumber(), businessCustomer.getAddress());
        this.id = businessCustomer.getId().toString();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
