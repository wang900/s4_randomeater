package fontys.randomeater.models;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
@Inheritance(strategy = InheritanceType.JOINED)
public class Restaurant extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String country;

    @Column(name = "zip_code", length = 10, nullable = false)
    private String zipCode;

    @Column(name = "house_number", length = 4, nullable = false)
    private String houseNumber;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

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
}
