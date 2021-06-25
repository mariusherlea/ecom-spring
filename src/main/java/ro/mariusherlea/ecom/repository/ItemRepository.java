package ro.mariusherlea.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mariusherlea.ecom.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
