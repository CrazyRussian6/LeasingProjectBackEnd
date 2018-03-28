package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;

/**
 * Created by Lukas on 2018-03-20.
 */
public class VehicleLeasingResponse extends LeasingResponse {

    private String manufacturer;

    private String model;

    private String manufacturingDate;

    private String enginePower;

    public VehicleLeasingResponse() {

    }

    public VehicleLeasingResponse(VehicleLeasing vehicleLeasing) {
        super(vehicleLeasing.getAdvancePaymentPercent(), vehicleLeasing.getAdvancePaymentAmount(),
                vehicleLeasing.getLeasingPeriod(), vehicleLeasing.getMargin(),
                vehicleLeasing.getContractFee(), vehicleLeasing.getAssetPrice(), vehicleLeasing.getPaymentDate(),
                vehicleLeasing.getCustomerID(), vehicleLeasing.getSubmissionDate(), vehicleLeasing.getLeasingStatus());
        this.manufacturer = vehicleLeasing.getManufacturer();
        this.model = vehicleLeasing.getModel();
        this.manufacturingDate = Integer.toString(vehicleLeasing.getManufacturingDate());
        this.enginePower = Integer.toString(vehicleLeasing.getEnginePower());
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

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }
}
