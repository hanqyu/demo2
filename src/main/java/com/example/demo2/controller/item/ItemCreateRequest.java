package com.example.demo2.controller.item;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemCreateRequest {
    private String name;
    private Integer quantity;
    private Long price;

    public ItemCreateRequest(String name, Integer quantity, Long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
