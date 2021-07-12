package ro.mariusherlea.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_detail")
public class OrderDetail extends AuditModel implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orders_id")
    @JsonIgnore
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private Item item;

    @Column(name = "item_quantity")
    private Double itemQuantityOrdered;

    @Column(name = "price_of_item_ordered")
    private Double priceOfItemOrdered;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Item item, Double itemQuantityOrdered, Double priceOfItemOrdered) {
        this.order = order;
        this.item = item;
        this.itemQuantityOrdered = itemQuantityOrdered;
        this.priceOfItemOrdered = priceOfItemOrdered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Double getItemQuantityOrdered() {
        return itemQuantityOrdered;
    }

    public void setItemQuantityOrdered(Double itemQuantityOrdered) {
        this.itemQuantityOrdered = itemQuantityOrdered;
    }

    public Double getPriceOfItemOrdered() {
        return priceOfItemOrdered;
    }

    public void setPriceOfItemOrdered(Double priceOfItemOrdered) {
        this.priceOfItemOrdered = priceOfItemOrdered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return id.equals(that.id) &&
                order.equals(that.order) &&
                item.equals(that.item) &&
                itemQuantityOrdered.equals(that.itemQuantityOrdered) &&
                priceOfItemOrdered.equals(that.priceOfItemOrdered);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, item, itemQuantityOrdered, priceOfItemOrdered);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", order=" + order +
                ", item=" + item +
                ", itemQuantityOrdered=" + itemQuantityOrdered +
                ", priceOfItemOrdered=" + priceOfItemOrdered +
                '}';
    }
}
