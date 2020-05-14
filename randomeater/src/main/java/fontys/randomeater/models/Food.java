package fontys.randomeater.models;

import fontys.randomeater.models.linktables.OrderFood;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "food")
@Inheritance(strategy = InheritanceType.JOINED)
public class Food extends BaseEntity {
    @Column(name = "name",  length = 50, nullable = false)
    private String name;

    @Column(name = "area", length = 50, nullable = false)
    private String area;

    @Column(name = "spicy", nullable = false)
    private boolean spicy;

    @Column(name = "allergy")
    private String allergy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
}
