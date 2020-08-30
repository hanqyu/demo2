package com.example.demo2.service.item;

import com.example.demo2.domain.item.Item;
import com.example.demo2.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item create(String name, Integer quantity, Long price) {
        Item item = new Item(name, quantity, price);
        return itemRepository.save(item);
    }

    public Optional<Item> getOne(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public void deleteById(long id) {
        itemRepository.deleteById(id);
    }


    // TODO partial update
    public Item update(Long id, String name, Integer quantity, Long price) {
        Item item = itemRepository.findById(id).get();  // TODO 더 나은방법?
        item.setName(name);
        item.setQuantity(quantity);
        item.setPrice(price);
        return itemRepository.save(item);
    }
}
