package fontys.randomeater.repositories;

import fontys.randomeater.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CRUDRepository<Restaurant, Long> {
}
