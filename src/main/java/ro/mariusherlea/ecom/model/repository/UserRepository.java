package ro.mariusherlea.ecom.model.repository;


import org.springframework.data.repository.CrudRepository;
import ro.mariusherlea.ecom.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
