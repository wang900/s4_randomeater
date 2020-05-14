package fontys.randomeater.services;

import fontys.randomeater.models.Food;
import fontys.randomeater.repositories.FoodRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodService extends CRUDService<Food, Long> {

    private FoodRepository repository;

    public FoodService(FoodRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
