package ro.mariusherlea.ecom.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mariusherlea.ecom.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
