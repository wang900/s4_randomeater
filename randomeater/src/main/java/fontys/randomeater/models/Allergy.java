package fontys.randomeater.models;

import javax.persistence.*;

@Entity
@Table(name = "allergy")
@Inheritance(strategy = InheritanceType.JOINED)
public class Allergy extends BaseEntity {

    @Column(length = 45, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
