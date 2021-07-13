package ro.mariusherlea.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ro.mariusherlea.ecom.exception.ResourceNotFoundException;
import ro.mariusherlea.ecom.model.Item;
import ro.mariusherlea.ecom.model.OrderDetail;
import ro.mariusherlea.ecom.model.repository.ItemRepository;
import ro.mariusherlea.ecom.model.repository.OrderDetailRepository;
import ro.mariusherlea.ecom.model.repository.OrderRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderDetailController {
    static double sum = 0D;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/orders/{orderId}/orderDetail")
    public List<OrderDetail> getAllOrderDetailByOrdersId(@PathVariable(value = "orderId") Long orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    @PostMapping("/orders/{orderId}/orderDetail/{itemId}")
    public OrderDetail createOrderDetail(@PathVariable(value = "itemId") Long itemId, @PathVariable(value = "orderId") Long orderId,
                                         @Valid @RequestBody OrderDetail orderDetail) {
        return orderRepository.findById(orderId).map(order -> {
            orderDetail.setOrder(order);
            itemRepository.findById(itemId).map(item -> {
                orderDetail.setItem(item);

                //calculus of item added in shopping cart based on Item.price and quantity ordered
                orderDetail.setPriceOfItemOrdered(item.getPrice() * orderDetail.getItemQuantityOrdered());

                List<OrderDetail> orderDetails = getAllOrderDetailByOrdersId(orderId);
                for (OrderDetail op : orderDetails) {
                    sum += op.getPriceOfItemOrdered();
                }
                order.setCostOfOrder(sum);
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