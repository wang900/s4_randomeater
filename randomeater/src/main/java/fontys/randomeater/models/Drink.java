package fontys.randomeater.models;

import javax.persistence.*;

@Entity
@Table(name = "drink")
@Inheritance(strategy = InheritanceType.JOINED)
public class Drink extends BaseEntity {
    @Column(name = "name",  length = 50, nullable = false)
    private String name;

    @Column(name = "area", length = 50, nullable = false)
    private String area;

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

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
}
