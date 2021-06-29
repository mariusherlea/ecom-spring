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


    @OneToMany(mappedBy = "comand")
    private Set<ComandDetail> registrations = new HashSet<>();

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




    public Set<ComandDetail> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<ComandDetail> registrations) {
        this.registrations = registrations;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Comand other = (Comand) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}