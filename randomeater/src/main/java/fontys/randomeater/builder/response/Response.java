package fontys.randomeater.builder.response;

import java.util.List;

public class Response<T> {

    private int amount;
    private String message;

    private List<T> result;

    public int getAmount() {
        return amount;
    }

    public Response<T> setAmount(int amount) {
        this.amount = amount;
        return this;
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
