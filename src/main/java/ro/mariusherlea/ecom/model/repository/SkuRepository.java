package ro.mariusherlea.ecom.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mariusherlea.ecom.model.Sku;

public interface SkuRepository extends JpaRepository<Sku, Long> {
}
