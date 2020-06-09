package fontys.randomeater.builder.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public class Response<T> {

    private int amount;
    private String message;
    private HttpStatus status;
    private List<T> result;

    public int getAmount() {
        return amount;
    }

    public Response<T> setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Response<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public List<T> getResult() {
        return result;
    }

    public Response<T> setResult(List<T> result) {
        this.result = result;
        return this;
    }
}
