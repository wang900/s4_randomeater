package fontys.randomeater.models;

import javax.persistence.*;

@Entity
@Table(name = "area")
@Inheritance(strategy = InheritanceType.JOINED)
public class Area extends BaseEntity {

    @Column(length = 45, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
