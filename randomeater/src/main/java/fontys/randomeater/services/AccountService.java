package fontys.randomeater.services;

import fontys.randomeater.models.Account;
import fontys.randomeater.repositories.AccountRepository;
import fontys.randomeater.security.Hasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends CRUDService<Account, Long> {

    private AccountRepository repository;

    public AccountService(AccountRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Account login(String email, String password) {
        Account a = repository.findByEmail(email);
        if(a != null) {
            if(!Hasher.compare(password, a.getPassword())) {
                a = null;
            }
        }
        return a;
    }

    //TODO: FINISH AUTHORIZATION WITH DTO
    public Account registerNewCustomerAccount(Account account) {

        if (emailExist(account.getEmail())) {
            return null;
        }
        return repository.save(account);
    }

    private boolean emailExist(String email) {
        return (repository.existsAccountByEmail(email));
    }
}
