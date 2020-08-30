package com.example.demo2.service.item.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemDto {

    private final String name;
    private final Integer quantity;
    private final Long price;

    @Builder
    public ItemDto(String name, Integer quantity, Long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
