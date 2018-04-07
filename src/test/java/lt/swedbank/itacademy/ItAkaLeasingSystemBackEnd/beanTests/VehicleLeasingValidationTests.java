package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beanTests;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.LeasingStatus;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class VehicleLeasingValidationTests {

    private static Validator validator;
    private static Set<ConstraintViolation<VehicleLeasing>> violations;
    private VehicleLeasing testLeasing;

    @Before
    public void setUp(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        initTestLeasing();
    }

    private void initTestLeasing(){
        this.testLeasing = new VehicleLeasing(
                new BigDecimal("15.7"),
                new BigDecimal("15000"),
                84,
                new BigDecimal("5.7"),
                new BigDecimal("1300"),
                new BigDecimal("150000"),
                15,
                "testCustomerID",
                LeasingStatus.PROCESSED,
                "testID840840",
                "Toyota",
                "Avensis",
                2004,
                125
        );
    }

    private void assertValidator(){
        assertEquals(1, validator.validate(testLeasing).size());
    }

    @Test
    public void AdvancePaymentPercentMaxTest(){
        testLeasing.setAdvancePaymentPercent(new BigDecimal(100.01));
        assertValidator();
    }

    @Test
    public void AdvancePaymentPercentMinTest() {
        testLeasing.setAdvancePaymentPercent(new BigDecimal(9.99));
        assertValidator();
    }

    @Test
    public void AdvancePaymentPercentNotNullTest() {
        testLeasing.setAdvancePaymentPercent(null);
        assertValidator();
    }

    @Test
    public void AdvancePaymentAmountNotNullTest() {
        testLeasing.setAdvancePaymentAmount(null);
        assertValidator();
    }

    @Test
    public void advancePaymentAmountMinTest() {
        testLeasing.setAdvancePaymentAmount(new BigDecimal(-0.77));
        assertValidator();
    }

    @Test
    public void leasingPeriodNotNullTest() {
        testLeasing.setLeasingPeriod(null);
        assertEquals(2, validator.validate(testLeasing).size());
    }

    @Test
    public void leasingPeriodMinTest() {
        testLeasing.setLeasingPeriod(0);
        assertValidator();
    }

    @Test
    public void leasingPeriodMaxTest() {
        testLeasing.setLeasingPeriod(90);
        assertValidator();
    }

    @Test
    public void leasingPeriodStepTest() {
        testLeasing.setLeasingPeriod(7);
        assertValidator();
    }

    @Test
    public void marginNotNullTest() {
        testLeasing.setMargin(null);
        assertValidator();
    }

    @Test
    public void marginMinTest() {
        testLeasing.setMargin(BigDecimal.valueOf(3.19));
        assertValidator();
    }

    @Test
    public void marginMaxTest() {
        testLeasing.setMargin(BigDecimal.valueOf(100.0004));
        assertValidator();
    }

    @Test
    public void contractFeeNotNullTest() {
        testLeasing.setContractFee(null);
        assertValidator();
    }

    @Test
    public void contractFeeMaxTest() {
        testLeasing.setContractFee(BigDecimal.valueOf(1000000001.12));
        assertValidator();
    }

    @Test
    public void assetPriceNotNullTest() {
        testLeasing.setAssetPrice(null);
        assertValidator();
    }

    @Test
    public void assetPriceMinTest() {
        testLeasing.setAssetPrice(BigDecimal.valueOf(-1));
        assertValidator();
    }

    @Test
    public void assetPriceMaxTest() {
        testLeasing.setAssetPrice(BigDecimal.valueOf(1000000001));
        assertValidator();
    }


    @Test
    public void paymentDateValueTest() {
        testLeasing.setPaymentDate(17);
        assertValidator();
    }
}
