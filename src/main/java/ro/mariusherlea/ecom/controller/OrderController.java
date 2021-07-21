package ro.mariusherlea.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mariusherlea.ecom.exception.ResourceNotFoundException;
import ro.mariusherlea.ecom.model.Order;
import ro.mariusherlea.ecom.model.repository.OrderRepository;
import ro.mariusherlea.ecom.model.repository.UserRepository;
import ro.mariusherlea.ecom.service.OrderService;

import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("/users/{userId}/order")
    public Page<Order> getAllOrderByUserId(@PathVariable (value = "userId") Long userId,
                                           Pageable pageable) {
        return orderRepository.findByUserId(userId, pageable);
    }

    @PostMapping("/users/{userId}/order")
    public Order createOrder(@PathVariable (value = "userId") Long userId,
                             @Valid @RequestBody Order order) {
        return userRepository.findById(userId).map(user -> {
            order.setUser(user);
            orderService.calcul(order, user);
            return orderRepository.save(order);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }

    /*@PutMapping("/users/{userId}/order/{orderId}")
    public Orders updateOrder(@PathVariable (value = "userId") Long userId,
                                 @PathVariable (value = "orderId") Long orderId,
                                 @Valid @RequestBody Orders orderRequest) {
        if(!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("UserId " + userId + " not found");
        }

        return orderRepository.findById(orderId).map(order -> {
            order.setUser(orderRequest.getUser());
            return orderRepository.save(order);
        }).orElseThrow(() -> new ResourceNotFoundException("OrderId " + orderId + "not found"));
    }*/

    @DeleteMapping("/users/{userId}/order/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable (value = "userId") Long userId,
                                           @PathVariable (value = "orderId") Long orderId) {
        return orderRepository.findByIdAndUserId(orderId, userId).map(order -> {
            orderRepository.delete(order);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + orderId + " and userId " + userId));
    }
}