package com.example.demo2.domain.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EntityManager em;

    private String uuid;

    @BeforeEach
    void setUp() {
        List<OrderItem> orderItems = Arrays.asList(
                new OrderItem("상의1", 2, 10000L),
                new OrderItem("하의1", 2, 20000L)
        );

        uuid = UUID.randomUUID().toString();

        Order order = Order.builder()
                .uuid(uuid)
                .orderNo("PICKK1234")
                .orderStatus(OrderStatus.PENDING)
                .orderer("한규주")
                .orderItems(orderItems)
                .build();

        orderRepository.saveAndFlush(order);

        em.clear();
    }

    @Test
    void name() {
        Order savedOrder = orderRepository.findById(uuid).get();

        savedOrder.getOrderItems();
    }
}