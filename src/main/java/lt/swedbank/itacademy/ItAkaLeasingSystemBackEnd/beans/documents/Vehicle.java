package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import org.bson.types.ObjectId;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Vehicle {

    @Id
    private ObjectId id;

    @NotNull(message = "vehicle groupValue can not be null")
    private String groupValue;

    private String text;

    @NotNull(message = "vehicle value can not be null")
    private String value;

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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
