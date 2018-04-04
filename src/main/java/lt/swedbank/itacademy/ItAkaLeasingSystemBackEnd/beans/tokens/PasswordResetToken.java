package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.tokens;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Customer;

import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

public class PasswordResetToken {

    @Id
    private BigInteger id;

    private String token;

    private String customerID;

    private Date expirationDate;

    private Date sendTime;

    public PasswordResetToken() {
    }

    public PasswordResetToken(String customerID, String token, Date expirationDate, Date sendTime){
        this.token = token;
        this.customerID = customerID;
        this.expirationDate = expirationDate;
        this.sendTime = sendTime;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
