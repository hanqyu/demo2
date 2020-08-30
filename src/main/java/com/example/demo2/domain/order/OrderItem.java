package com.example.demo2.domain.order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer quantity;

    @Column
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    private Order order;

    public OrderItem(String name, Integer quantity, Long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void updateOrder(Order order) {
        this.order = order;
    }
}
