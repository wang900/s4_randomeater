package fontys.randomeater.controllers;

import fontys.randomeater.models.Drink;
import fontys.randomeater.services.DrinkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drinks")
public class DrinkController extends CRUDController<Drink> {

    DrinkController(DrinkService service) {
        super(service);
    }
}
