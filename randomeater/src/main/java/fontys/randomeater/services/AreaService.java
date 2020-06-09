package fontys.randomeater.services;

import fontys.randomeater.models.Area;
import fontys.randomeater.repositories.AreaRepository;
import org.springframework.stereotype.Service;

@Service
public class AreaService extends CRUDService<Area, Long> {
    private AreaRepository repository;

    public AreaService(AreaRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
