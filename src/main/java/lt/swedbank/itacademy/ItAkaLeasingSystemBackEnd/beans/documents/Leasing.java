package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.LeasingStatus;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.constraints.LeasingPeriodStepConstraint;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.constraints.PaymentDateValueConstraint;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class Leasing {

    @NotNull(message = "advance payment percent must be specified")
    @DecimalMin(value = "10", message = "advance payment percentage can not be less than 10 percent")
    @DecimalMax(value = "100", message = "advance payment percentage can not be greater than 100")
    private BigDecimal advancePaymentPercent;

    @NotNull(message = "advance payment amount must be specified")
    @Min(value = 0, message = "advance payment amount can not be less than 0")
    private BigDecimal advancePaymentAmount;

    @NotNull(message = "leasing period must be specified")
    @Min(value = 6, message = "leasing period can not be less than 6 months")
    @Max(value = 84, message = "leasing period can not be more than 84 months")
    @LeasingPeriodStepConstraint(message = "incorrect leasing period")
    private int leasingPeriod;

    @NotNull(message = "margin must be specified")
    @DecimalMin(value = "3.2", message = "margin can not be less than 3.2%")
    @DecimalMax(value = "100", message = "margin can not be greater than 100%")
    private BigDecimal margin;

    @NotNull(message = "contract fee must be specified")
 //   @Max(value = 1000000000, message = "contract fee can not be greater than 1000000000")
    @DecimalMax(value="1000000000.00", message = "contract fee must be nummeric format and not greater then 1000000000")
    private BigDecimal contractFee;

    @NotNull(message = "asset price must be specified")
    @Min(value = 0, message = "asset price can not be less than 0")
    @Max(value = 1000000000, message = "asset price can not be greter than 1000000000")
    private BigDecimal assetPrice;

    @NotNull(message = "payment date must be specified")
    @PaymentDateValueConstraint(value = {15, 30})
    private int paymentDate;

    @NotNull(message = "leasing must be assigned to customer")
    private String customerID;

    //@NotNull(message = "leasing status must be defined")
    private LeasingStatus leasingStatus;

    //@NotNull(message = "submission date must be defined")
    private Date submissionDate;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public BigDecimal getAdvancePaymentPercent() {
        return advancePaymentPercent;
    }

    public void setAdvancePaymentPercent(BigDecimal advancePaymentPercent) {
        this.advancePaymentPercent = advancePaymentPercent;
    }

    public BigDecimal getAdvancePaymentAmount() {
        return advancePaymentAmount;
    }

    public void setAdvancePaymentAmount(BigDecimal advancePaymentAmount) {
        this.advancePaymentAmount = advancePaymentAmount;
    }

    public int getLeasingPeriod() {
        return leasingPeriod;
    }

    public void setLeasingPeriod(int leasingPeriod) {
        this.leasingPeriod = leasingPeriod;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public BigDecimal getContractFee() {
        return contractFee;
    }

    public void setContractFee(BigDecimal contractFee) {
        this.contractFee = contractFee;
    }

    public BigDecimal getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(BigDecimal assetPrice) {
        this.assetPrice = assetPrice;
    }

    public int getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(int paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LeasingStatus getLeasingStatus() {
        return leasingStatus;
    }

    public void setLeasingStatus(LeasingStatus leasingStatus) {
        this.leasingStatus = leasingStatus;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }
}
