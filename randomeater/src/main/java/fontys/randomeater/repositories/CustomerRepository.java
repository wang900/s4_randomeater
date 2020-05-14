package fontys.randomeater.repositories;

import fontys.randomeater.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CRUDRepository<Customer, Long> {
}
