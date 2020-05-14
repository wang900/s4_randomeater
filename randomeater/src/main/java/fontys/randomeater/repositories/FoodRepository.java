package fontys.randomeater.repositories;

import fontys.randomeater.models.Food;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CRUDRepository<Food, Long> {
//    @Query(value="SELECT f FROM FOOD f WHERE f.Area = :area ORDER BY RAND() " +
//            "LIMIT 1")
//    List<Food> findByAreaRandom(Area area);
}
