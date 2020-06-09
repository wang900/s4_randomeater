package fontys.randomeater.builder;

import fontys.randomeater.builder.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ResponseDirector {
    @Autowired
    private ResponseBuilder builder;

    public Response<?> getSuccessResponse(int amount, List<Object> result, HttpStatus status) {
        builder.reset();
        builder.setAmount(amount);
        builder.setResult(result);
        builder.setMessage("");
        builder.setStatus(status);
        return builder.getResult();
    }
    public Response<?> getSuccessResponse(int amount, Object result, HttpStatus status) {
        List<Object> list = new ArrayList<>();
        list.add(result);
        return this.getSuccessResponse(amount, list, status);
    }

    public Response<?> getFailResponse(String message, HttpStatus status) {
        builder.reset();
        builder.setMessage(message);
        builder.setStatus(status);
        return builder.getResult();
    }
}
