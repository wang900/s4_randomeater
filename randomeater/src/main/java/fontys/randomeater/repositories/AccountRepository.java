package fontys.randomeater.repositories;

import fontys.randomeater.models.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CRUDRepository<Account, Long> {
    Account findByEmail(String email);

    boolean existsAccountByEmail(String email);
}
