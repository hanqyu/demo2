package com.example.demo2.service.item;

import com.example.demo2.domain.item.Item;
import com.example.demo2.domain.item.ItemRepository;
import com.example.demo2.service.item.converter.ItemConverter;
import com.example.demo2.service.item.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemConverter itemConverter;

    public ItemDto create(String name, Integer quantity, Long price) {
        Item savedItem = itemRepository.save(new Item(name, quantity, price));
        return itemConverter.convertToDto(savedItem);
    }

    public ItemDto getOne(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
        return itemConverter.convertToDto(item);
    }

    public List<ItemDto> findAll() {
        return itemRepository.findAll()
                .stream()
                .map(item -> itemConverter.convertToDto(item))
                .collect(Collectors.toList());
    }

    public void deleteById(long id) {
        itemRepository.deleteById(id);
    }


    // TODO partial update
    public ItemDto update(Long id, String name, Integer quantity, Long price) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
        item.updateItem(name, quantity, price);
        return itemConverter.convertToDto(item);
    }
}
