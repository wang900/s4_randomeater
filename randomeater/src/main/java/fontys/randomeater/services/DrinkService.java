package fontys.randomeater.services;

import fontys.randomeater.models.Drink;
import fontys.randomeater.repositories.DrinkRepository;
import org.springframework.stereotype.Service;

@Service
public class DrinkService extends CRUDService<Drink, Long> {
    public DrinkService(DrinkRepository repository) {
        super(repository);
    }
}
