package fontys.randomeater.services;

import fontys.randomeater.models.Order;
import fontys.randomeater.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends CRUDService<Order, Long> {

    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
