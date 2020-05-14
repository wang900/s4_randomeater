package fontys.randomeater.services;

import fontys.randomeater.repositories.CRUDRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public class CRUDService<T, ID> {

    private CRUDRepository<T, ID> repository;

    public CRUDService(CRUDRepository repository) {
        this.repository = repository;
    }

    public Iterable<T> findAll() {
        return this.repository.findAll();
    }

    public T findById(ID id) {
        Optional<T> result = this.repository.findById(id);
        return result.orElse(null);
    }

    public T update(T object) {
        return this.repository.save(object);
    }

    public void deleteById(ID id) {
        this.repository.deleteById(id);
    }
}
