package fontys.randomeater.repositories;

import fontys.randomeater.models.Account;
import fontys.randomeater.models.Customer;
import fontys.randomeater.models.Customer;
import fontys.randomeater.models.Allergy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class CustomerRepositoryTest {


    @Autowired
    CustomerRepository repository;

    @Test
    public void insertTest() {
        Customer customer = createCustomer();
        repository.save(customer);

        assertNotNull(repository.findById(customer.getId()));
        assertEquals("Netherlands", customer.getCountry());
    }

    @Test
    public void updateTest() {
        Customer customer = createCustomer();

        repository.save(customer);

        assertNotNull(repository.findById(customer.getId()));
        assertEquals("Netherlands", customer.getCountry());

        customer.setCountry("Germany");
        repository.save(customer);

        assertEquals("Germany", customer.getCountry());
    }

    @Test
    public void deleteTest() {
        Customer customer = createCustomer();

        repository.save(customer);

        assertNotNull(repository.findById(customer.getId()));

        repository.delete(customer);

        assertFalse(repository.existsById(customer.getId()));
    }

    private Customer createCustomer() {
        Account account = new Account();
        account.setEmail("happy@gmail.com");
        account.setPassword("test");
        Customer customer = new Customer();
        customer.setName("Henk van Houten");
        customer.setZipCode("2392GS");
        customer.setHouseNumber("12");
        customer.setCountry("Netherlands");
        customer.setAccount(account);
        return customer;
    }


    @Test
    public void allergyTest() {
        String allergyName = "Milk intolerance";
        String allergyName2 = "Nut intolerance";

        Allergy allergy = new Allergy();
        Allergy allergy2 = new Allergy();

        Customer customer = createCustomer();
        customer.getAllergies().add(allergy);
        customer.getAllergies().add(allergy2);
        repository.save(customer);

        Optional<Customer> dbCustomer = repository.findById(customer.getId());
        assertNotNull(dbCustomer);
        Set<Allergy> allergies = dbCustomer.orElse(new Customer()).getAllergies();

        assertTrue(allergies.size() > 1);
        assertTrue(allergies.contains(allergy));
        assertTrue(allergies.contains(allergy2));
    }
}
