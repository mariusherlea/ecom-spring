package ro.mariusherlea.ecom.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mariusherlea.ecom.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
