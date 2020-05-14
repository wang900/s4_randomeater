package fontys.randomeater.services;

import fontys.randomeater.models.Restaurant;
import fontys.randomeater.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService extends CRUDService<Restaurant, Long> {

    private RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
