package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;


import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.LeasingStatus;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


public class VehicleLeasing extends Leasing {

    @Id
    private String id;

    @NotNull(message = "manufacturer must be specified")
    private String manufacturer;

    @NotNull(message = "model must be specified")
    private String model;

    @NotNull(message = "manufacturing date must be specified")
    @Min(value = 2000, message = "manufacturing date can not be less than 2000")
    private int manufacturingDate;

    @NotNull(message = "engine power must be specified")
    @Min(value = 0, message = "engine power must be greater than 0")
    @Max(value = 1000, message = "engine power must be leser tahn 1000")
    private int enginePower;

    public VehicleLeasing() {
    }

    public VehicleLeasing(BigDecimal advancePaymentPercent, BigDecimal advancePaymentAmount, int leasingPeriod,
                          BigDecimal margin, BigDecimal contractFee, BigDecimal assetPrice, int paymentDate,
                          String customerID, LeasingStatus leasingStatus, String id,
                          String manufacturer, String model, int manufacturingDate, int enginePower) {
        super(advancePaymentPercent, advancePaymentAmount, leasingPeriod, margin, contractFee, assetPrice, paymentDate, customerID, leasingStatus);
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.enginePower = enginePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(int manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
