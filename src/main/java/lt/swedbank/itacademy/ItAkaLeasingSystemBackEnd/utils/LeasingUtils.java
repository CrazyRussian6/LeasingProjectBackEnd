package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Leasing;

import java.math.BigDecimal;

/**
 * Created by Lukas on 2018-03-20.
 */
public class LeasingUtils {

    public static BigDecimal calculateAdvancePaymentAmount(Leasing leasing) throws IllegalArgumentException{
        BigDecimal paymentPercentagePercent = leasing.getAdvancePaymentPercent()
                .divide(new BigDecimal(100), BigDecimal.ROUND_CEILING)
                .setScale(3, BigDecimal.ROUND_CEILING);
        BigDecimal advancePaymentAmount = paymentPercentagePercent.multiply(leasing.getAssetPrice());
        if(advancePaymentAmount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Advance payment amount can not be below zero");
        }
        return paymentPercentagePercent.multiply(leasing.getAssetPrice());
    }
}
