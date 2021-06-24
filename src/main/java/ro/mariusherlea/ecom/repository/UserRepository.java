package ro.mariusherlea.ecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mariusherlea.ecom.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
