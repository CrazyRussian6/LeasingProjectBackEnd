package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Vehicle;

public class VehicleResponse {

    private String groupValue;

    private String value;

    private String text;

    private String id;


    public VehicleResponse() {
    }

    public VehicleResponse(Vehicle vehicle) {
        this.id = vehicle.getId().toString();
        this.groupValue = vehicle.getGroupValue();
        this.value = vehicle.getValue();
        this.text = text;
    }

    public String getGroupValue() {
        return groupValue;
    }

    public void setGroupValue(String groupValue) {
        this.groupValue = groupValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
