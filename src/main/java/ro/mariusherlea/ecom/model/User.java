package ro.mariusherlea.ecom.model;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import java.util.Objects;

@Entity
@Table(name = "user")
public class User extends AuditModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "User must be between 4 to 15 characters")
    @Size(min = 4, max = 15)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "continent")
    private Integer continent;

    public User() {
    }

    public User(String name, String email, Integer continent) {
        this.name = name;
        this.email = email;
        this.continent = continent;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getContinent() {
        return continent;
    }

    public void setContinent(Integer continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                name.equals(user.name) &&
                email.equals(user.email) &&
                continent.equals(user.continent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, continent);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}
