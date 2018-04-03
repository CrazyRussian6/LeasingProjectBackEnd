package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.enums.AdministratorType;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Administrator {

    @Id
    private ObjectId id;

    @NotNull(message = "administrator login ID can not be null")
    private String userID;

    @NotNull(message = "administrator password must be specified")
    private String password;

    @NotNull(message = "administrator type must be specified")
    private AdministratorType administratorType;

    public Administrator() {
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdministratorType getAdministratorType() {
        return administratorType;
    }

    public void setAdministratorType(AdministratorType administratorType) {
        this.administratorType = administratorType;
    }
}
