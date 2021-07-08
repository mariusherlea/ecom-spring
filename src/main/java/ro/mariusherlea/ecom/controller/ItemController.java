package ro.mariusherlea.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mariusherlea.ecom.exception.ResourceNotFoundException;
import ro.mariusherlea.ecom.model.Item;
import ro.mariusherlea.ecom.model.repository.ItemRepository;

import javax.validation.Valid;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/items")
    public Page<Item> getAllItems(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    @PostMapping("/items")
    public Item createItem(@Valid @RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PutMapping("/items/{itemId}")
    public Item updateItem(@PathVariable Long itemId, @Valid @RequestBody Item itemRequest) {
        return itemRepository.findById(itemId).map(item -> {
            item.setName(itemRequest.getName());
            item.setStock(itemRequest.getStock());
            return itemRepository.save(item);
        }).orElseThrow(() -> new ResourceNotFoundException("ItemId " + itemId + " not found"));
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable Long itemId) {
        return itemRepository.findById(itemId).map(item -> {
            itemRepository.delete(item);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ItemId " + itemId + " not found"));
    }


}
