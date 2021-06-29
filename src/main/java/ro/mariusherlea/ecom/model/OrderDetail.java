package ro.mariusherlea.ecom.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Column(name = "item_quantity")
    private Double ItemQuantityOrdered;

    public OrderDetail() {
    }

    public OrderDetail(Orders orders, Item item, LocalDateTime registeredAt, Double itemQuantityOrdered) {
        this.orders = orders;
        this.item = item;
        this.registeredAt = registeredAt;
        ItemQuantityOrdered = itemQuantityOrdered;
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

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Double getItemQuantityOrdered() {
        return ItemQuantityOrdered;
    }

    public void setItemQuantityOrdered(Double grade) {
        this.ItemQuantityOrdered = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return id.equals(that.id) &&
                orders.equals(that.orders) &&
                item.equals(that.item) &&
                registeredAt.equals(that.registeredAt) &&
                ItemQuantityOrdered.equals(that.ItemQuantityOrdered);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orders, item, registeredAt, ItemQuantityOrdered);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orders=" + orders +
                ", item=" + item +
                ", registeredAt=" + registeredAt +
                ", ItemQuantityOrdered=" + ItemQuantityOrdered +
                '}';
    }
}
