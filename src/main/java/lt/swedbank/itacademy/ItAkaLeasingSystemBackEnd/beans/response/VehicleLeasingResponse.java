package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.VehicleLeasing;

/**
 * Created by Lukas on 2018-03-20.
 */
public class VehicleLeasingResponse extends LeasingResponse {

    private String manufactorer;

    private String model;

    private String manufactoringDate;

    private String enginePower;

    public VehicleLeasingResponse() {

    }

    public VehicleLeasingResponse(VehicleLeasing vehicleLeasing) {
        super(vehicleLeasing.getAdvancePaymentPercent(), vehicleLeasing.getAdvancePaymentAmount(),
                vehicleLeasing.getLeasingPeriod(), vehicleLeasing.getMargin(),
                vehicleLeasing.getContractFee(), vehicleLeasing.getAssetPrice(), vehicleLeasing.getPaymentDate());
        this.manufactorer = vehicleLeasing.getManufacturer();
        this.model = vehicleLeasing.getModel();
        this.manufactoringDate = Integer.toString(vehicleLeasing.getManufacturingDate());
        this.enginePower = Integer.toString(vehicleLeasing.getEnginePower());
    }

    public String getManufactorer() {
        return manufactorer;
    }

    public void setManufactorer(String manufactorer) {
        this.manufactorer = manufactorer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufactoringDate() {
        return manufactoringDate;
    }

    public void setManufactoringDate(String manufactoringDate) {
        this.manufactoringDate = manufactoringDate;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }
}
