package ro.mariusherlea.ecom.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 250)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 100)
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String description) {
        this.email = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String content) {
        this.phone = content;
    }
}