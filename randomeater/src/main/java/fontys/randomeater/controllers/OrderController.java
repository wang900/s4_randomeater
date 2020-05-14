package fontys.randomeater.controllers;

import fontys.randomeater.models.Order;
import fontys.randomeater.services.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController extends CRUDController<Order> {

    OrderController(OrderService service) {
        super(service);
    }
}
