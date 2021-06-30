package ro.mariusherlea.ecom.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
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

    @OneToMany(mappedBy = "item")
    private List<Sku> skus;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private Double stock;

    public Item() {
    }

    public Item(Set<OrderDetail> orderDetails, List<Sku> skus, String name, Double stock) {
        this.orderDetails = orderDetails;
        this.skus = skus;
        this.name = name;
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

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                skus.equals(item.skus) &&
                name.equals(item.name) &&
                stock.equals(item.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDetails, skus, name, stock);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", orderDetails=" + orderDetails +
                ", skus=" + skus +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }
}