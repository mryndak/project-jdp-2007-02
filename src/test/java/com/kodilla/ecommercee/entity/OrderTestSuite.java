package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderItem;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserStatus;
import com.kodilla.ecommercee.repository.OrderItemRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuite {
//    @Autowired
//    OrderRepository orderRepository;
//    @Autowired
//    OrderItemRepository orderItemRepository;
//    @Autowired
//    UserRepository userRepository;
//    @Test
//    public void testOrderSave() {
//        //Given
//        Order order= new Order();
//        order.setTotalPrice(new BigDecimal(22.3));
//        order.setPaid(true);
//        List<OrderItem> orderItems = new ArrayList<>();
//        OrderItem orderItem = new OrderItem();
//        orderItem.setProductId(2L);
//        orderItem.setQuantity(22);
//        orderItem.setPrice(BigDecimal.valueOf(22.3));
//        orderItem.setOrder(order);
//        orderItems.add(orderItem);
//        order.setItems(orderItems);
//        //When
//        orderRepository.save(order);
//        //Then
//        Long orderId = order.getId();
//        Optional<Order> readOrder = orderRepository.findById(orderId);
//        Assert.assertTrue(readOrder.isPresent());
//        //CleanUp
//        orderRepository.deleteById(orderId);
//    }
//
//    @Test
//    public void testOrderDelete() {
//        //Given
//        User user = new User();
//        user.setUserName("pablo");
//        user.setStatus(UserStatus.TO_ACTIVATE);
//        user.setUserKey(2L);
//        user.setFirstName("Paweł");
//        user.setLastName("Kowalski");
//        user.setBirthDate(LocalDate.of(1993,2,2));
//        user.setRegisterDate(LocalDate.now());
//        user.setEmail("pablo@wp.pl");
//        user.setCity("Wrocław");
//        user.setPostCode("50-374");
//        user.setStreet("Bierutowska");
//        user.setHouseNr("235");
//        user.setPhoneNumber("222-222-222");
//        user.setLogin("paolo");
//        user.setPassword("qwerty");
//        Order order= new Order();
//        order.setTotalPrice(new BigDecimal(22.3));
//        order.setPaid(true);
//        List<OrderItem> orderItems = new ArrayList<>();
//        OrderItem orderItem = new OrderItem();
//        orderItem.setProductId(2L);
//        orderItem.setQuantity(22);
//        orderItem.setPrice(BigDecimal.valueOf(22.3));
//        orderItem.setOrder(order);
//        orderItems.add(orderItem);
//        order.setItems(orderItems);
//        order.setUser(user);
//        user.getOrders().add(order);
//        userRepository.save(user);
//        orderRepository.save(order);
//        orderItemRepository.save(orderItem);
//        Long orderId = order.getId();
//        Long orderItemId = orderItem.getId();
//        Long userId = user.getId();
//        //When
//        orderRepository.deleteById(orderId);
//        Optional<OrderItem> readOrderItem = orderItemRepository.findById(orderItemId);
//        Optional<Order> readOrder = orderRepository.findById(orderId);
//        Optional<User> readUser = userRepository.findById(userId);
//        //Then
//        Assert.assertFalse(readOrder.isPresent());
//        Assert.assertFalse(readOrderItem.isPresent());
//        Assert.assertTrue(readUser.isPresent());
//        //CleanUp
//        userRepository.deleteById(userId);
//    }
//
//    @Test
//    public void testOrderUpdate() {
//        //Given
//        Order order= new Order();
//        order.setTotalPrice(new BigDecimal(22.3));
//        order.setPaid(false);
//        List<OrderItem> orderItems = new ArrayList<>();
//        OrderItem orderItem = new OrderItem();
//        orderItem.setProductId(2L);
//        orderItem.setQuantity(22);
//        orderItem.setPrice(BigDecimal.valueOf(22.3));
//        orderItem.setOrder(order);
//        orderItems.add(orderItem);
//        order.setItems(orderItems);
//        orderRepository.save(order);
//        //When
//        order.setPaid(true);
//        orderRepository.save(order);
//        //Then
//        Long orderId = order.getId();
//        Order readOrder = orderRepository.findById(orderId).orElse(null);
//        Assert.assertTrue(readOrder.isPaid());
//        //CleanUp
//        orderRepository.deleteById(orderId);
//    }
}
