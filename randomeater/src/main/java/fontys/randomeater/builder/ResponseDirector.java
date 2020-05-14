package fontys.randomeater.builder;

import fontys.randomeater.builder.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ResponseDirector {
    @Autowired
    private ResponseBuilder builder;

    public Response getSuccessResponse(int amount, List<Object> result) {
        builder.reset();
        builder.setAmount(amount);
        builder.setResult(result);
        builder.setMessage("");
        return builder.getResult();
    }
    public Response getSuccessResponse(int amount, Object result) {
        List<Object> list = new ArrayList<>();
        list.add(result);

        return this.getSuccessResponse(amount, list);
    }

    public Response getFailResponse(String message) {
        builder.reset();
        builder.setMessage(message);
        return builder.getResult();
    }
}
