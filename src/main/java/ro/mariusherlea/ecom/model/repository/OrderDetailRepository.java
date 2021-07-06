package ro.mariusherlea.ecom.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ro.mariusherlea.ecom.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    Page<OrderDetail> findByOrderId(Long orderId, Pageable pageable);
}
