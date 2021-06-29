package ro.mariusherlea.ecom.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comand_detail")
public class ComandDetail {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comand_id")
    private User comand;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Column(name = "grade")
    private int grade;

    // additional properties

    public ComandDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getComand() {
        return comand;
    }

    public void setComand(User comand) {
        this.comand = comand;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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
        ComandDetail other = (ComandDetail) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
