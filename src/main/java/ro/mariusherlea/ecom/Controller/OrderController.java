package ro.mariusherlea.ecom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ro.mariusherlea.ecom.Exception.ResourceNotFoundException;
import ro.mariusherlea.ecom.model.Orders;
import ro.mariusherlea.ecom.model.repository.OrderRepository;
import ro.mariusherlea.ecom.model.repository.UserRepository;

import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{userId}/orders")
    public Page<Orders> getAllOrderByUserId(@PathVariable (value = "userId") Long userId,
                                               Pageable pageable) {
        return orderRepository.findByUserId(userId, pageable);
    }

    @PostMapping("/users/{userId}/orders")
    public Orders createOrder(@PathVariable (value = "userId") Long userId,
                                 @Valid @RequestBody Orders orders) {
        return userRepository.findById(userId).map(user -> {
            orders.setUser(user);
            return orderRepository.save(orders);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }


}