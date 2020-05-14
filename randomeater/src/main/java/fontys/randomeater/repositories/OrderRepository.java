package fontys.randomeater.repositories;


import fontys.randomeater.models.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CRUDRepository<Order, Long> {
}
