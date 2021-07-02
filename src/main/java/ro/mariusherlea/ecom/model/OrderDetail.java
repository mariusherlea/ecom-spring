package ro.mariusherlea.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_detail")
public class OrderDetail extends AuditModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orders_id")
    @JsonIgnore
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private Item item;


    @Column(name = "item_quantity")
    private Double itemQuantityOrdered;

    public OrderDetail() {
    }

    public OrderDetail(Orders orders, Item item,  Double itemQuantityOrdered) {
        this.orders = orders;
        this.item = item;

        this.itemQuantityOrdered = itemQuantityOrdered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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

    public void setItemQuantityOrdered(Double grade) {
        this.itemQuantityOrdered = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return id.equals(that.id) &&
                orders.equals(that.orders) &&
                item.equals(that.item) &&

                itemQuantityOrdered.equals(that.itemQuantityOrdered);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orders, item, itemQuantityOrdered);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orders=" + orders +
                ", item=" + item +

                ", ItemQuantityOrdered=" + itemQuantityOrdered +
                '}';
    }
}
