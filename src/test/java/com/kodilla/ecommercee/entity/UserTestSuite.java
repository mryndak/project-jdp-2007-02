package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderItemRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    private User userData() {
        User user = new User();
        user.setUserName("OrzelZnadWisly120");
        user.setStatus(UserStatus.TO_ACTIVATE);
        user.setUserKey(1L);
        user.setFirstName("Adam");
        user.setLastName("Małysz");
        user.setBirthDate(LocalDate.of(1980, 8, 18));
        user.setRegisterDate(LocalDate.now());
        user.setEmail("orzel@malysz.pl");
        user.setCity("Wisła");
        user.setPostCode("12-345");
        user.setStreet("Sniezna");
        user.setHouseNr("12");
        user.setPhoneNumber("010-12-13-14");
        user.setLogin("orzel120");
        user.setPassword("qwerty123");
        return user;
    }

    private Cart cartData() {
        Product product = new Product();
        List<Product> products = new ArrayList<>();
        Cart cart = new Cart();
        cart.setTotalPrice(new BigDecimal(200));
        cart.setId(1L);
        cart.setQuantity(1);
        cart.setUser(userData());
        cart.setProducts(products);
        return cart;
    }

    private Order orderAndOrderItemData() {
        Product product = new Product();

        OrderItem orderItem = new OrderItem();
        orderItem.setId(1L);
        orderItem.setProduct(product);
        Order order = new Order();
        List<Order> orderList = new ArrayList<>();
//        OrderItem orderItem = new OrderItem();
        List<OrderItem> orderItemList = new ArrayList<>();
        order.setId(1L);
        order.setUser(userData());
        order.setTotalPrice(new BigDecimal(300));
        order.setDateOfOrder(LocalDate.now());
        order.setDateOfShipment(LocalDate.now());
        order.setDeliveryMethod("Paczkomat");
        order.setPaid(true);
        order.setOrderCompleted(true);
        order.setComment("Llalala");
        order.setItems(orderItemList);
        return order;
    }

    @Test
    public void testSaveUser() {
        //GIVEN
        User user = userData();
        //WHEN
        userRepository.save(user);
        //THEN
        Long userId = user.getId();
        Optional<User> readUser = userRepository.findById(userId);
        Assert.assertTrue(readUser.isPresent());
        //CLEANUP
        userRepository.deleteById(userId);
    }

    @Test
    public void testUpdateCart() {
        //GIVEN
        User user = userData();
        userRepository.save(user);
        //WHEN
        user.setFirstName("Janusz");
        user.setPassword("janusz123");
        userRepository.save(user);
        //THEN
        Long userId = user.getId();
        User readUser = userRepository.findById(userId).orElse(null);
        Assert.assertEquals(readUser.getFirstName(), "Janusz");
        Assert.assertEquals(readUser.getPassword(), "janusz123");
        //CLEANUP
        userRepository.deleteById(userId);
    }

    @Test
    public void testDeleteUser() {
        //GIVEN
        User user = userData();
        Cart cart = cartData();
        Long userId = user.getId();
        //WHEN
        userRepository.deleteById(userId);
        //THEN
        Optional<User> readUser = userRepository.findById(userId);
        Assert.assertFalse(readUser.isPresent());
    }

}
