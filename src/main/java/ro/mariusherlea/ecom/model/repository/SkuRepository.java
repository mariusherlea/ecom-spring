package ro.mariusherlea.ecom.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ro.mariusherlea.ecom.model.Sku;

public interface SkuRepository extends JpaRepository<Sku, Long> {
    Page<Sku> findByItemId(Long itemId, Pageable pageable);


}
