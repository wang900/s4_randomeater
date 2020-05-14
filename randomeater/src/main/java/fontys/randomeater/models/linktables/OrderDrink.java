package fontys.randomeater.models.linktables;

import fontys.randomeater.models.Drink;
import fontys.randomeater.models.Order;

import javax.persistence.*;

@Entity
@Table(name = "order_drink")
public class OrderDrink {

    @EmbeddedId
    private OrderDrinkKey id;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("drink_id")
    @JoinColumn(name = "drink_id")
    private Drink drink;

    @Column
    private int size;

    public OrderDrinkKey getId() {
        return id;
    }

    public void setId(OrderDrinkKey id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
