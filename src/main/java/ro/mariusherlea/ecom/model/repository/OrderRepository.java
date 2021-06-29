package ro.mariusherlea.ecom.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mariusherlea.ecom.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
