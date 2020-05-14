package fontys.randomeater.controllers;

import fontys.randomeater.models.Restaurant;
import fontys.randomeater.services.RestaurantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController extends CRUDController<Restaurant> {

    RestaurantController(RestaurantService service) {
        super(service);
    }
}
