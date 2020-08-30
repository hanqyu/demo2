package com.example.demo2.controller.item;

import com.example.demo2.controller.item.dto.ItemCreateRequest;
import com.example.demo2.controller.item.dto.ItemUpdateRequest;
import com.example.demo2.domain.item.Item;
import com.example.demo2.service.item.ItemService;
import com.example.demo2.service.item.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/items")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemCreateRequest request) {
        ItemDto item = itemService.create(request.getName(), request.getQuantity(), request.getPrice());
        return ResponseEntity.ok(item);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity getItem(@PathVariable Long id) {
        ItemDto item = itemService.getOne(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemDto>> getItems() {
        List<ItemDto> items = itemService.findAll();
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        itemService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // TODO partial update
    @PutMapping("/items/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long id, @RequestBody ItemUpdateRequest request) {
        ItemDto item = itemService.update(id, request.getName(), request.getQuantity(), request.getPrice());
        return ResponseEntity.ok(item);
    }
}

