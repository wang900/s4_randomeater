package fontys.randomeater.builder;


import fontys.randomeater.builder.response.Response;
import org.springframework.http.HttpStatus;

import java.util.List;

public class RestResponseBuilder implements ResponseBuilder {
    private Response response;

    public RestResponseBuilder() {
        this.reset();
    }

    @Override
    public void setAmount(int amount) {
        response.setAmount(amount);
    }

    @Override
    public void setMessage(String message) {
        response.setMessage(message);
    }

    @Override
    public void setStatus(HttpStatus status) {
        response.setStatus(status);
    }

    @Override
    public void setResult(List result) {
        response.setResult(result);
    }

    @Override
    public void reset() {
        this.response = new Response<>();
    }

    @Override
    public Response getResult() {
        return this.response;
    }
}
