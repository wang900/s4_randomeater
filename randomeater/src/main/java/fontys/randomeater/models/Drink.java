package fontys.randomeater.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drink")
@Inheritance(strategy = InheritanceType.JOINED)
public class Drink extends BaseEntity {
    @Column(name = "name",  length = 50, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name="area_id", nullable=false)
    private Area area;

    @ManyToMany
    @JoinColumn(name = "drink_id")
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

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }
}
