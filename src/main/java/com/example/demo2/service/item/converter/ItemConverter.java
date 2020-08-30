package com.example.demo2.service.item.converter;

import com.example.demo2.domain.item.Item;
import com.example.demo2.service.item.dto.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {

    public ItemDto convertToDto(Item item) {
        return ItemDto.builder()
                .name(item.getName())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .build();
    }
}
