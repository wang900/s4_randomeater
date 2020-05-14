package fontys.randomeater.controllers;

import fontys.randomeater.models.Customer;
import fontys.randomeater.services.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController extends CRUDController<Customer> {

    CustomerController(CustomerService service) {
        super(service);
    }
}
