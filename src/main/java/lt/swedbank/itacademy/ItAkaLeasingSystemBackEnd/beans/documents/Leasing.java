package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Leasing {

    @NotNull
    private BigDecimal advancePaymentPercent;

    @NotNull
    private BigDecimal advancePaymentAmount;

    @NotNull
    private int leasingPeriod;

    @NotNull
    private BigDecimal margin;

    @NotNull
    private BigDecimal contractFee;

    @NotNull
    private BigDecimal assetPrice;

    @NotNull
    private int paymentDate;

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
}
