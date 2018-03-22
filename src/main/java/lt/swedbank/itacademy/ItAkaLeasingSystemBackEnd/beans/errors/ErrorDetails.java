package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.beans.errors;

import java.util.List;

/**
 * @author Lukas
 */
public class ErrorDetails {
    private String timestamp;
    private String message;
    private List<String> details;

    public ErrorDetails() {
    }

    public ErrorDetails(String timestamp, String message, List<String> details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
