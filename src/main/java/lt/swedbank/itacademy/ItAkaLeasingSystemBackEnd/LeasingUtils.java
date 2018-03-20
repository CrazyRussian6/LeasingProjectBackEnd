package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Leasing;

import java.math.BigDecimal;

/**
 * Created by Lukas on 2018-03-20.
 */
public class LeasingUtils {

    public static BigDecimal calculateAdvancePaymentAmount(Leasing leasing) {
        BigDecimal advancePaymentAmount = BigDecimal.ZERO;
        BigDecimal paymentPercentagePercent = leasing.getAdvancePaymentPercent()
                .divide(new BigDecimal(100), BigDecimal.ROUND_CEILING)
                .setScale(3, BigDecimal.ROUND_CEILING);
        advancePaymentAmount = paymentPercentagePercent.multiply(leasing.getAssetPrice());
        return advancePaymentAmount;
    }
}
