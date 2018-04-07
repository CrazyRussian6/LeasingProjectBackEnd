package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.response;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents.Administrator;

public class AdministratorResponse extends Response{

    private String userID;
    private String administratorType;

    public AdministratorResponse() {

    }

    public AdministratorResponse(Administrator administrator) {
        this.userID = administrator.getUserID();
        this.administratorType = administrator.getAdministratorType().toString();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAdministratorType() {
        return administratorType;
    }

    public void setAdministratorType(String administratorType) {
        this.administratorType = administratorType;
    }
}
