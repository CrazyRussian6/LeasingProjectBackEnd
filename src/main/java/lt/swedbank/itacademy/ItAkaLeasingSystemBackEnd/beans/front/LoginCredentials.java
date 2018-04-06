package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.front;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginCredentials
{
    @Id
    private String userId;
    @NotNull
    @Size(min=6, max=20, message="Password must be longer then 6 symbols ant shorter then 20")
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
