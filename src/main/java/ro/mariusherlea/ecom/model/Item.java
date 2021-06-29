package ro.mariusherlea.ecom.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "item")
    private Set<OrderDetail> orderDetails = new HashSet<>();

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Double stock;

    public Item() {
    }

    public Item(Long id, String name, Double price, Double stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) &&
                orderDetails.equals(item.orderDetails) &&
                name.equals(item.name) &&
                price.equals(item.price) &&
                stock.equals(item.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDetails, name, price, stock);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", orderDetails=" + orderDetails +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}