package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils.LeasingUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItAkaLeasingSystemBackEndApplicationTests {


    private VehicleLeasing initializeVehicleLeasing(String manufacturer, String model, int manufacturingDate, int enginePower,
                                                    BigDecimal advancePaymentPercent,
                                                    int leasingPeriod, BigDecimal margin, BigDecimal contractFee,
                                                    BigDecimal assetPrice, int paymentDate){
        VehicleLeasing vehicleLeasing = new VehicleLeasing();
        vehicleLeasing.setManufacturer(manufacturer);
        vehicleLeasing.setModel(model);
        vehicleLeasing.setManufacturingDate(manufacturingDate);
        vehicleLeasing.setEnginePower(enginePower);
        vehicleLeasing.setAdvancePaymentPercent(advancePaymentPercent);
        vehicleLeasing.setLeasingPeriod(leasingPeriod);
        vehicleLeasing.setMargin(margin);
        vehicleLeasing.setContractFee(contractFee);
        vehicleLeasing.setAssetPrice(assetPrice);
        vehicleLeasing.setPaymentDate(paymentDate);
        return vehicleLeasing;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void LeasingAdvancePaymentAmountPositiveTest(){
        VehicleLeasing leasing = initializeVehicleLeasing("Toyota", "Avensis", 2000,
                50, BigDecimal.valueOf(15), 12, BigDecimal.valueOf(3.5), BigDecimal.valueOf(150), BigDecimal.valueOf(7500), 30);
        assertTrue(LeasingUtils.calculateAdvancePaymentAmount(leasing).compareTo(BigDecimal.ZERO) > 0);
    }
}
