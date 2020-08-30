package com.example.demo2.domain.order;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {

    @Id
    private String uuid;

    @Column(nullable = false)
    private String orderNo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private OrderStatus orderStatus;

    @Column(nullable = false)
    private String orderer;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Builder
    public Order(String uuid, String orderNo, OrderStatus orderStatus, String orderer, List<OrderItem> orderItems) {
        this.uuid = uuid;
        this.orderNo = orderNo;
        this.orderStatus = orderStatus;
        this.orderer = orderer;

        orderItems.forEach(orderItem -> orderItem.updateOrder(this));
        this.orderItems.addAll(orderItems);
    }
}
