package fontys.randomeater.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "food")
@Inheritance(strategy = InheritanceType.JOINED)
public class Food extends BaseEntity {
    @Column(name = "name",  length = 50, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name="area_id", nullable=false)
    private Area area;

    @Column(name = "spicy", nullable = false)
    private boolean spicy;

    @ManyToMany
    @JoinColumn(name = "food_id")
    private List<Allergy> allergies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }
}
