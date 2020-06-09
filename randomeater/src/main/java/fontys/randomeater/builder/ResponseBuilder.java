package fontys.randomeater.builder;

import fontys.randomeater.builder.response.Response;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ResponseBuilder extends Builder<Response<Object>> {
    void setAmount(int amount);
    void setMessage(String message);
    void setResult(List<Object> result);
    void setStatus(HttpStatus status);
}
