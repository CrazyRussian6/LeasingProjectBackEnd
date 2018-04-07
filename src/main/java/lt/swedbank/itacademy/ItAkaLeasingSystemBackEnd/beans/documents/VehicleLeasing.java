package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

/*<<<<<<< HEAD
=======*/
import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.LeasingStatus;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/*<<<<<<< HEAD
=======*/
import java.math.BigDecimal;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6

public class VehicleLeasing extends Leasing {

    @Id
/*<<<<<<< HEAD
    private ObjectId id;
=======*/
    private String id;
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6

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

/*<<<<<<< HEAD
=======*/
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

//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
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

/*<<<<<<< HEAD
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
=======*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
//>>>>>>> 2bfc9abe011b41dddb33e52f635fe6b884c937b6
        this.id = id;
    }
}
