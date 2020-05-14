package fontys.randomeater.controllers;

import fontys.randomeater.builder.ResponseDirector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBase<T> {
    @Autowired
    ResponseDirector responseDirector;
}
