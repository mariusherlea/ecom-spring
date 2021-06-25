package ro.mariusherlea.ecom.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    private Double price;

    @NotNull
    @Size(max = 50)
    private Double stock;

    public Item() {
    }

    public Item(String name, Double price, Double stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
