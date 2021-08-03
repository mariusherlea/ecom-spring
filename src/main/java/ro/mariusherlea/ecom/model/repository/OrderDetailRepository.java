package ro.mariusherlea.ecom.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import ro.mariusherlea.ecom.model.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrderId(Long orderId);
}
