package polyakov.nametranscriptor.exception;

public class ErrorResponse {
    private final String status;
    private final String error;

    public ErrorResponse(String status, String errors) {
        this.status = status;
        this.error = errors;
    }

    public String getError() {
        return error;
    }

    public String getStatus() {
        return status;
    }
}
