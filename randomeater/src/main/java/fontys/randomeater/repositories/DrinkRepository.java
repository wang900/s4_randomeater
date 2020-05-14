package fontys.randomeater.repositories;

import fontys.randomeater.models.Drink;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends CRUDRepository<Drink, Long> {
}
