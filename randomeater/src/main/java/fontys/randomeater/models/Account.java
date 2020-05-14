package fontys.randomeater.models;

import fontys.randomeater.security.Hasher;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name="account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account extends BaseEntity {
    @Email
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(nullable = false)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
