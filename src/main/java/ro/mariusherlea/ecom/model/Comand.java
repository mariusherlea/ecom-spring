package ro.mariusherlea.ecom.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comand")
public class Comand {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany(mappedBy = "comand")
    private Set<ComandDetail> comandDetails = new HashSet<>();

    // additional properties

    public Comand() {
    }

    public Comand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ComandDetail> getComandDetails() {
        return comandDetails;
    }

    public void setComandDetails(Set<ComandDetail> comandDetails) {
        this.comandDetails = comandDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }



}