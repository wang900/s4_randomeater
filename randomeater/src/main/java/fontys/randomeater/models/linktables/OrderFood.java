package fontys.randomeater.models.linktables;

import fontys.randomeater.models.Food;
import fontys.randomeater.models.Order;

import javax.persistence.*;

@Entity
@Table(name = "order_food")
public class OrderFood {

    @EmbeddedId
    private OrderFoodKey id;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("food_id")
    @JoinColumn(name = "food_id")
    private Food food;

    @Column
    private int size;

    public OrderFoodKey getId() {
        return id;
    }

    public void setId(OrderFoodKey id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
