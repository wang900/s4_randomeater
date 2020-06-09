package fontys.randomeater.models.linktables;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDrinkKey implements Serializable {
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "drink_id")
    private long drinkId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(long drinkId) {
        this.drinkId = drinkId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
