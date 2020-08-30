package com.example.demo2.domain.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor(access = AccessLevel.PACKAGE)  // TODO
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer quantity;

    @Column
    private Long price;

    public Item(String name, Integer quantity, Long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

}