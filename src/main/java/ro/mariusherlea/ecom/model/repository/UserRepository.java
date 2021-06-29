package ro.mariusherlea.ecom.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mariusherlea.ecom.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
