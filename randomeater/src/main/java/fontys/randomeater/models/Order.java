package fontys.randomeater.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Inheritance(strategy = InheritanceType.JOINED)
public class Order extends BaseEntity {

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
