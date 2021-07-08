package ro.mariusherlea.ecom.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item")
public class Item extends AuditModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private Double stock;

    @Column(name = "price")
    private Double price;

    public Item() {
    }

    public Item(String name, Double stock, Double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) &&
                name.equals(item.name) &&
                stock.equals(item.stock) &&
                price.equals(item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stock, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}