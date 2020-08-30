package com.example.demo2.controller.item;

import com.example.demo2.domain.item.Item;
import com.example.demo2.domain.item.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ItemControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ItemRepository itemRepository;

    String name = "이름";
    Long price = 1000L;
    int quantity = 1;

    Item createTestItem() {
        Item item = new Item(name, quantity, price);
        return itemRepository.save(item);
    }

    @BeforeEach
    void setup() {
        itemRepository.deleteAll();
    }

    @Test
    void createItem() {
        ItemCreateRequest request = new ItemCreateRequest("이름", 1, 1000L);
        webTestClient.post()
                .uri("/items")
                .body(BodyInserters.fromValue(request))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("name").isEqualTo("이름")
                .jsonPath("quantity").isEqualTo(1)
                .jsonPath("price").isEqualTo(1000);
    }
    @Test
    void getItem() {
        Long id = createTestItem().getId();
        webTestClient.get()
                .uri(String.format("/items/%s", id))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("id").isEqualTo(id)
                .jsonPath("name").isEqualTo("이름")
                .jsonPath("quantity").isEqualTo(1)
                .jsonPath("price").isEqualTo(1000);
    }

    @Test
    void getItems() {
        createTestItem();
        createTestItem();

        webTestClient.get()
                .uri("/items")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Item.class)
                .hasSize(2);
    }

    @Test
    void deleteItem() {
        Item item = createTestItem();
        webTestClient.delete()
                .uri(String.format("/items/%s", item.getId()))
                .exchange()
                .expectStatus().isOk();
        assertEquals(itemRepository.findById(item.getId()), Optional.empty());
    }

    @Test
    void updateItem() {
        Item item = createTestItem();
        String newName = "anmse";
        int newQuantity = 3;
        long newPrice = 2000L;
        Item request = new Item(newName, newQuantity, newPrice);
        webTestClient.put()
                .uri(String.format("/items/%s", item.getId()))
                .body(BodyInserters.fromValue(request))
                .exchange()
                .expectStatus().isOk();

        Item updatedItem = itemRepository.findById(item.getId()).get();
        assertEquals(updatedItem.getName(), newName);
        assertEquals(updatedItem.getQuantity(), newQuantity);
        assertEquals(updatedItem.getPrice(), newPrice);
    }
}