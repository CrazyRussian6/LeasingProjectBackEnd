package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import java.math.BigDecimal;

/**
 * Created by Lukas on 2018-03-20.
 */
public abstract class LeasingResponse extends Response{

    private String advancePaymentPercent;

    private String advancePaymentAmount;

    private String leasingPeriod;

    private String margin;

    private String contractFee;

    private String assetPrice;

    private String paymentDate;

    private String customerID;

    public LeasingResponse(){

    }

    public LeasingResponse(BigDecimal advancePaymentPercent, BigDecimal advancePaymentAmount, int leasingPeriod,
                           BigDecimal margin, BigDecimal contractFee, BigDecimal assetPrice, int paymentDate,
                           String customerID) {
        this.advancePaymentPercent = advancePaymentPercent.toString();
        this.advancePaymentAmount = advancePaymentAmount.toString();
        this.leasingPeriod = Integer.toString(leasingPeriod);
        this.margin = margin.toString();
        this.contractFee = contractFee.toString();
        this.assetPrice = assetPrice.toString();
        this.paymentDate = Integer.toString(paymentDate);
        this.customerID = customerID;
    }

    public String getAdvancePaymentPercent() {
        return advancePaymentPercent;
    }

    public void setAdvancePaymentPercent(String advancePaymentPercent) {
        this.advancePaymentPercent = advancePaymentPercent;
    }

    public String getAdvancePaymentAmount() {
        return advancePaymentAmount;
    }

    public void setAdvancePaymentAmount(String advancePaymentAmount) {
        this.advancePaymentAmount = advancePaymentAmount;
    }

    public String getLeasingPeriod() {
        return leasingPeriod;
    }

    public void setLeasingPeriod(String leasingPeriod) {
        this.leasingPeriod = leasingPeriod;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getContractFee() {
        return contractFee;
    }

    public void setContractFee(String contractFee) {
        this.contractFee = contractFee;
    }

    public String getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(String assetPrice) {
        this.assetPrice = assetPrice;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
