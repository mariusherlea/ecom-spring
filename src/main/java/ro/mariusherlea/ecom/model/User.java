package ro.mariusherlea.ecom.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                orders.equals(user.orders) &&
                name.equals(user.name) &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orders, name, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", orders=" + orders +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
