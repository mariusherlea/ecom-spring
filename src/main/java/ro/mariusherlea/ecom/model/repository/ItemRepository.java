package ro.mariusherlea.ecom.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ro.mariusherlea.ecom.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
