package ro.mariusherlea.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order extends AuditModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")

    @JsonIgnore
    private User user;

    @Column(name = "cost")
    private Double costOfOrder=0.d;

    @Column(name = "shipping")
    private Double shipping =0.d;

    public Order() {
    }

    public Order(User user, Double costOfOrder, Double shipping) {
        this.user = user;
        this.costOfOrder = costOfOrder;
        this.shipping = shipping;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getCostOfOrder() {
        return costOfOrder;
    }

    public void setCostOfOrder(Double costOfOrder) {
        this.costOfOrder = costOfOrder;
    }

    public Double getShipping() {
        return shipping;
    }

    public void setShipping(Double costWithShipping) {
        this.shipping = costWithShipping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                user.equals(order.user) &&
                costOfOrder.equals(order.costOfOrder) &&
                shipping.equals(order.shipping);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, costOfOrder, shipping);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", costOfOrder=" + costOfOrder +
                ", costWithShipping=" + shipping +
                '}';
    }
}