package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.documents;

/**
 * @author Lukas
 */
public class PasswordRequest {

    String userId;
    String oldPassword;
    String newPassword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
