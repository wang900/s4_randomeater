package fontys.randomeater.controllers;

import fontys.randomeater.models.Food;
import fontys.randomeater.services.FoodService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController extends CRUDController<Food> {

    FoodController(FoodService service) {
        super(service);
    }
}
