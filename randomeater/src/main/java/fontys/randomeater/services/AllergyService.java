package fontys.randomeater.services;

import fontys.randomeater.models.Allergy;
import fontys.randomeater.repositories.AllergyRepository;
import org.springframework.stereotype.Service;

@Service
public class AllergyService extends CRUDService<Allergy, Long> {
    private AllergyRepository repository;


    public AllergyService(AllergyRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
