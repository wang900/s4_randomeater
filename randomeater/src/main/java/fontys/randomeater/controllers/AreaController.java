package fontys.randomeater.controllers;

import fontys.randomeater.models.Area;
import fontys.randomeater.services.AreaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/areas")
public class AreaController extends CRUDController<Area> {

    AreaController(AreaService service) {
        super(service);
    }
}
