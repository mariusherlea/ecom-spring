package ro.mariusherlea.ecom.model.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.mariusherlea.ecom.model.Orders;

import java.util.Optional;


public interface OrderRepository extends JpaRepository<Orders, Long> {
    Page<Orders> findByUserId(Long userId, Pageable pageable);
    Optional<Orders> findByIdAndUserId(Long id, Long userId);
}
