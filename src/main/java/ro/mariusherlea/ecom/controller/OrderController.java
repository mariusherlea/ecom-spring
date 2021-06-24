package ro.mariusherlea.ecom.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mariusherlea.ecom.exception.ResourceNotFoundException;
import ro.mariusherlea.ecom.model.Order;
import ro.mariusherlea.ecom.repository.OrderRepository;
import ro.mariusherlea.ecom.repository.UserRepository;

import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{userId}/orders")
    public Page<Order> getAllOrdersByUserId(@PathVariable (value = "userId") Long userId,
                                            Pageable pageable) {
        return orderRepository.findByUserId(userId, pageable);
    }

    @PostMapping("/users/{userId}/orders")
    public Order createOrder(@PathVariable (value = "userId") Long userId,
                             @Valid @RequestBody Order order) {
        return userRepository.findById(userId).map(user -> {
            order.setUser(user);
            return orderRepository.save(order);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }

    @PutMapping("/users/{userId}/orders/{orderId}")
    public Order updateOrder(@PathVariable (value = "userId") Long userId,
                             @PathVariable (value = "orderId") Long orderId,
                             @Valid @RequestBody Order orderRequest) {
        if(!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("UserId " + userId + " not found");
        }

        return orderRepository.findById(orderId).map(order -> {
            return orderRepository.save(order);
        }).orElseThrow(() -> new ResourceNotFoundException("OrderId " + orderId + "not found"));
    }

    @DeleteMapping("/users/{userId}/orders/{orderId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "userId") Long userId,
                                           @PathVariable (value = "orderId") Long orderId) {
        return orderRepository.findByIdAndUserId(orderId, userId).map(order -> {
            orderRepository.delete(order);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + orderId + " and userId " + userId));
    }
}