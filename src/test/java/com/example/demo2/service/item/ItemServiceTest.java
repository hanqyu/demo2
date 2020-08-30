//package com.example.demo2.service.item;
//
//import com.example.demo2.domain.item.Item;
//import com.example.demo2.domain.item.ItemRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ItemServiceTest {
//
//    @Autowired
//    private ItemService itemService;
//
//    @Autowired
//    private ItemRepository itemRepository;
//
//    String name = "이름";
//    Long price = 1000L;
//    int quantity = 1;
//
//    Item createItem() {
//        Item item = new Item(name, quantity, price);
//        return itemRepository.save(item);
//    }
//
//    @BeforeEach
//    void setup() {
//        itemRepository.deleteAll();
//    }
//
//    @Test
//    @DisplayName("생성 테스트")
//    void create() {
//        Item savedItem = itemService.create(name, quantity, price);
//
//        assertThat(savedItem.getId()).isNotNull();
//        assertEquals(savedItem.getName(), name);
//        assertEquals(savedItem.getPrice(), price);
//        assertEquals(savedItem.getQuantity(), quantity);
//    }
//
//    @Test
//    void getOne() {
//        Item savedItem = createItem();
//
//        Optional<Item> retrievedItem = itemService.getOne(savedItem.getId());
//
//        assertTrue(retrievedItem.isPresent());
//        Item item = retrievedItem.get();
//        assertEquals(item.getId(), savedItem.getId());
//        assertEquals(item.getName(), name);
//        assertEquals(item.getPrice(), price);
//        assertEquals(item.getQuantity(), quantity);
//    }
//
//    @Test
//    void findAll() {
//        Item savedItem1 = createItem();
//        Item savedItem2 = createItem();
//        List<Item> items = itemService.findAll();
//
//        assertEquals(items.get(0).getId(), savedItem1.getId());
//        assertEquals(items.get(1).getId(), savedItem2.getId());
//    }
//
//    @Test
//    void deleteById() {
//        Item savedItem = createItem();
//        itemService.deleteById(savedItem.getId());
//        Optional<Item> foundItem = itemRepository.findById(savedItem.getId());
//        assertFalse(foundItem.isPresent());
//    }
//
//    @Test
//    void update() {
//        Item item = createItem();
//        String newName = "이름2";
//        int newQuantity = 10;
//        long newPrice = 2000L;
//        Item savedItem = itemService.update(item.getId(), newName, newQuantity, newPrice);
//
//        assertEquals(savedItem.getId(), item.getId());
//        assertEquals(savedItem.getName(), newName);
//        assertEquals(savedItem.getPrice(), newPrice);
//        assertEquals(savedItem.getQuantity(), newQuantity);
//    }
//}