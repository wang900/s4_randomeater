package fontys.randomeater.repositories;

import fontys.randomeater.models.Allergy;
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
public class AllergyRepositoryTest {

    @Autowired
    AllergyRepository repository;

    private Allergy createAllergy() {
        Allergy allergy = new Allergy();
        allergy.setName("Milk intolerance");
        return allergy;
    }

    @Test
    public void insertTest() {
        Allergy allergy = createAllergy();

        repository.save(allergy);

        assertNotNull(repository.findById(allergy.getId()));
        assertEquals("Milk intolerance", allergy.getName());
    }

    @Test
    public void updateTest() {
        Allergy allergy = createAllergy();

        repository.save(allergy);

        assertNotNull(repository.findById(allergy.getId()));
        assertEquals("Milk intolerance", allergy.getName());

        allergy.setName("Nut intolerance");
        repository.save(allergy);

        assertEquals("Nut intolerance", allergy.getName());
    }

    @Test
    public void deleteTest() {
        Allergy allergy = createAllergy();

        repository.save(allergy);

        assertNotNull(repository.findById(allergy.getId()));

        repository.delete(allergy);

        assertFalse(repository.existsById(allergy.getId()));
    }
}
