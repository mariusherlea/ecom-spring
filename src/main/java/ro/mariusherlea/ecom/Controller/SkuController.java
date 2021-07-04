package ro.mariusherlea.ecom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ro.mariusherlea.ecom.Exception.ResourceNotFoundException;
import ro.mariusherlea.ecom.model.Sku;
import ro.mariusherlea.ecom.model.repository.ItemRepository;
import ro.mariusherlea.ecom.model.repository.SkuRepository;

import javax.validation.Valid;

@RestController
public class SkuController {

    @Autowired
    private SkuRepository skuRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/items/{itemId}/skus")
    public Page<Sku> getAllSkuByItemId(@PathVariable (value = "itemId") Long itemId,
                                       Pageable pageable) {
        return skuRepository.findByItemId(itemId, pageable);
    }

    @PostMapping("/items/{itemId}/skus")
    public Sku createSku(@PathVariable (value = "itemId") Long itemId,
                          @Valid @RequestBody Sku sku) {
        return itemRepository.findById(itemId).map(item -> {
            sku.setItem(item);
            return skuRepository.save(sku);
        }).orElseThrow(() -> new ResourceNotFoundException("ItemId " + itemId + " not found"));
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

   /* @DeleteMapping("/users/{userId}/order/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable (value = "userId") Long userId,
                                           @PathVariable (value = "orderId") Long orderId) {
        return skuRepository.findByIdAndUserId(orderId, userId).map(order -> {
            skuRepository.delete(order);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + orderId + " and userId " + userId));
    }*/
}