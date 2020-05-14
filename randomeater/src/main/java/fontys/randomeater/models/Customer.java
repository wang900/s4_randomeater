package fontys.randomeater.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends BaseEntity {

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 20)
    private String country;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    @Column(name = "house_number", length = 4)
    private String houseNumber;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToMany
    private Set<Allergy> allergies = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(Set<Allergy> allergies) {
        this.allergies = allergies;
    }

}
