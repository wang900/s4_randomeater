package fontys.randomeater.services;

import fontys.randomeater.models.Customer;
import fontys.randomeater.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends CRUDService<Customer, Long> {
    public CustomerService(CustomerRepository repository) {
        super(repository);
    }
}
