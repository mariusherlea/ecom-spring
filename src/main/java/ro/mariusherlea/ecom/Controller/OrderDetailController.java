package ro.mariusherlea.ecom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ro.mariusherlea.ecom.Exception.ResourceNotFoundException;
import ro.mariusherlea.ecom.model.OrderDetail;
import ro.mariusherlea.ecom.model.repository.ItemRepository;
import ro.mariusherlea.ecom.model.repository.OrderDetailRepository;
import ro.mariusherlea.ecom.model.repository.OrderRepository;

import javax.validation.Valid;

@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/orders/{orderId}/orderDetail")
    public Page<OrderDetail> getAllOrderDetailByOrdersId(@PathVariable(value = "orderId") Long orderId,
                                                         Pageable pageable) {
        return orderDetailRepository.findByOrderId(orderId, pageable);
    }

    @PostMapping("/orders/{orderId}/orderDetail/{itemId}")
    public OrderDetail createOrderDetail(@PathVariable(value = "itemId") Long itemId, @PathVariable(value = "orderId") Long orderId,
                                         @Valid @RequestBody OrderDetail orderDetail) {
        return orderRepository.findById(orderId).map(order -> {
            orderDetail.setOrders(order);
            itemRepository.findById(itemId).map(item -> {
                orderDetail.setItem(item);
                return null;
            });
            return orderDetailRepository.save(orderDetail);


        }).orElseThrow(() -> new ResourceNotFoundException("OrderId " + orderId + " not found"));
    }

/*
    @PutMapping("/users/{userId}/order/{orderId}")
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
    }

    @DeleteMapping("/users/{userId}/order/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable (value = "userId") Long userId,
                                           @PathVariable (value = "orderId") Long orderId) {
        return orderRepository.findByIdAndUserId(orderId, userId).map(order -> {
            orderRepository.delete(order);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + orderId + " and userId " + userId));
    }*/
}