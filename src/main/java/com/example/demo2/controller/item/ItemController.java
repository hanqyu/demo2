package com.example.demo2.controller.item;

import com.example.demo2.domain.item.Item;
import com.example.demo2.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody ItemCreateRequest request) {
        Item item = itemService.create(request.getName(), request.getQuantity(), request.getPrice());
        return ResponseEntity.ok(item);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity getItem(@PathVariable Long id) {
        Optional<Item> item = itemService.getOne(id);
        if (item.isPresent()) {
            return ResponseEntity.ok(item);
        } else {
            return (ResponseEntity) ResponseEntity.notFound();
        }

    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItems() {
        List<Item> items = itemService.findAll();
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        itemService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // TODO partial update
    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item request) {
        Item item = itemService.update(id, request.getName(), request.getQuantity(), request.getPrice());
        return ResponseEntity.ok(item);
    }
}

