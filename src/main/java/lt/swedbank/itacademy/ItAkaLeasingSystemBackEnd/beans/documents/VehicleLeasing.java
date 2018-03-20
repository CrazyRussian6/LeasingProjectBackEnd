package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class VehicleLeasing extends Leasing {

    @NotNull
    private String manufactorer;

    @NotNull
    private String model;

    @NotNull
    private int manufactoringDate;

    @NotNull
    private int enginePower;

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

    public int getManufactoringDate() {
        return manufactoringDate;
    }

    public void setManufactoringDate(int manufactoringDate) {
        this.manufactoringDate = manufactoringDate;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
}
