package ro.mariusherlea.ecom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mariusherlea.ecom.Exception.ResourceNotFoundException;
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

   /* @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }*/

}
