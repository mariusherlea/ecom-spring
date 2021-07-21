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

    @Column(name = "base_price")
    private Double basePrice=0d;

    @Column(name = "discount")
    private Double discount=0d;

    @Column(name = "price_to_pay")
    private Double priceToPay=0d;

    public Item() {
    }

    public Item(String name, Double stock, Double basePrice, Double discount, Double priceToPay) {
        this.name = name;
        this.stock = stock;
        this.basePrice = basePrice;
        this.discount = discount;
        this.priceToPay = priceToPay;
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

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getPriceToPay() {
        return priceToPay;
    }

    public void setPriceToPay(Double priceToPay) {
        this.priceToPay = priceToPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) &&
                name.equals(item.name) &&
                stock.equals(item.stock) &&
                basePrice.equals(item.basePrice) &&
                discount.equals(item.discount) &&
                priceToPay.equals(item.priceToPay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stock, basePrice, discount, priceToPay);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", basePrice=" + basePrice +
                ", discount=" + discount +
                ", priceToPay=" + priceToPay +
                '}';
    }
}