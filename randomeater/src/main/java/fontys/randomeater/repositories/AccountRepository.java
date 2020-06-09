package fontys.randomeater.repositories;

import fontys.randomeater.models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CRUDRepository<Account, Long> {

    @Query("select a.id from Account a where a.email = :email")
    Account findByEmail(String email);

    boolean existsAccountByEmail(String email);
}
