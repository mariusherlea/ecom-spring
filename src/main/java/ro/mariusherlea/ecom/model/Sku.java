package ro.mariusherlea.ecom.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "sku")
public class Sku {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;

    @Column(name = "price")
    private Double price;

    public Sku() {
    }

    public Sku(Long id, Item item, Double price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        Sku sku = (Sku) o;
        return id.equals(sku.id) &&
                item.equals(sku.item) &&
                price.equals(sku.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, price);
    }

    @Override
    public String toString() {
        return "Sku{" +
                "id=" + id +
                ", item=" + item +
                ", price=" + price +
                '}';
    }
}