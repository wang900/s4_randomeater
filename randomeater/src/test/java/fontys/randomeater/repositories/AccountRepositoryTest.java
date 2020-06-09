package fontys.randomeater.repositories;

import fontys.randomeater.models.Account;
import fontys.randomeater.security.Hasher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class AccountRepositoryTest {


    @Autowired
    AccountRepository repository;

    @Test
    public void insertTest() {
        Account account = createAccount();

        repository.save(account);

        assertNotNull(repository.findById(account.getId()));
        assertEquals("happy@gmail.com", account.getEmail());
    }

    @Test
    public void updateTest() {
        Account account = createAccount();

        repository.save(account);

        assertNotNull(repository.findById(account.getId()));
        assertEquals("happy@gmail.com", account.getEmail());

        account.setEmail("unhappy@gmail.com");
        repository.save(account);

        assertEquals("unhappy@gmail.com", account.getEmail());
    }

    @Test
    public void deleteTest() {
        Account account = createAccount();

        repository.save(account);

        assertNotNull(repository.findById(account.getId()));

        repository.delete(account);

        assertFalse(repository.existsById(account.getId()));
    }

//    @Test
//    public void authorizationTest() {
//        Account account = createAccount();
//
//        repository.save(account);
//
//        assertNotNull(repository.findById(account.getId()));
//        Hasher.current();
//        boolean actual = Hasher.compare("test", repository.findById(account.getId()).orElse(new Account()).getPassword());
//        assertTrue(actual);
//    }

    private Account createAccount() {
        Account account = new Account();
        account.setEmail("happy@gmail.com");
        account.setPassword("test");
        return account;
    }
}
