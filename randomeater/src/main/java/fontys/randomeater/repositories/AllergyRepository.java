package fontys.randomeater.repositories;

import fontys.randomeater.models.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergyRepository extends CRUDRepository<Allergy, Long> {
}
