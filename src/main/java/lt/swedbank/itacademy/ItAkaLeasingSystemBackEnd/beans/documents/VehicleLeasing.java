package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class VehicleLeasing extends Leasing {

    @Id
    private ObjectId id;

    @NotNull(message = "manufacturer must be specified")
    private String manufacturer;

    @NotNull(message = "model must be specified")
    private String model;

    @NotNull(message = "manufacturing date must be specified")
    @Min(value = 2000, message = "manufacturing date can not be less than 2000")
    private int manufacturingDate;

    @NotNull(message = "engine power must be specified")
    @Min(value = 0, message = "engine power must be greater than 0")
    private int enginePower;

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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
