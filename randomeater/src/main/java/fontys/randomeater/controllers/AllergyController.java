package fontys.randomeater.controllers;

import fontys.randomeater.models.Allergy;
import fontys.randomeater.services.AllergyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allergies")
public class AllergyController extends CRUDController<Allergy> {

    AllergyController(AllergyService service) {
        super(service);
    }
}
