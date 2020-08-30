package com.example.demo2.controller.item.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemUpdateRequest {
    private String name;
    private Integer quantity;
    private Long price;

    public ItemUpdateRequest(String name, Integer quantity, Long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
