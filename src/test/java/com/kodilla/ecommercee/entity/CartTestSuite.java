package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.*;
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
public class CartTestSuite {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void testSaveCart() {
        //Given
        Cart cart = new Cart();
        cart.setTotalPrice(new BigDecimal(200.00));
        cart.setQuantity(33);

        User user = getUserData();
        GetCartAndUserData(cart, user);

        //When
        cartRepository.save(cart);

        //Then
        Long cartId = cart.getId();
        Long userId = user.getId();
        Optional<Cart> readCart = cartRepository.findById(cartId);
        Assert.assertTrue(readCart.isPresent());

        //CleanUp
        cartRepository.deleteById(cartId);
        userRepository.deleteById(userId);
    }

    @Test
    public void testUpdateCart() {
        //Given
        Cart cart = new Cart();
        cart.setTotalPrice(new BigDecimal(200.00));
        cart.setQuantity(33);

        User user = getUserData();
        GetCartAndUserData(cart, user);
        cartRepository.save(cart);
        //When
        cart.setTotalPrice(new BigDecimal(500.00));
        cartRepository.save(cart);

        //Then
        Long cartId = cart.getId();
        Long userId = user.getId();
        Assert.assertEquals(new BigDecimal(500.00), cart.getTotalPrice());

        //CleanUp
        cartRepository.deleteById(cartId);
        userRepository.deleteById(userId);
    }

    @Test
    public void testDeleteCart() {
        //Given

        Cart cart = new Cart();
        cart.setTotalPrice(new BigDecimal(200.00));
        cart.setQuantity(33);

        User user = getUserData();
        GetCartAndUserData(cart, user);

        cartRepository.save(cart);
        Long idCart = cart.getId();

        //When
        cartRepository.deleteById(idCart);
        Optional<Cart> byId = cartRepository.findById(idCart);
        //Then
        Assert.assertFalse(byId.isPresent());

    }

    private User getUserData() {
        User user = new User();
        user.setUserName("johnyko");
        user.setStatus(UserStatus.ACTIVE);
        user.setUserKey(66L);
        user.setFirstName("John");
        user.setLastName("Kowalski");
        user.setBirthDate(LocalDate.of(1980, 12, 12));
        user.setRegisterDate(LocalDate.now());
        user.setEmail("john@gmail.com");
        user.setCity("Warszawa");
        user.setPostCode("00-001");
        user.setStreet("Piastowska");
        user.setHouseNr("6");
        user.setPhoneNumber("6-6-6-6-6-6-6");
        user.setLogin("johnyko");
        user.setPassword("adsfgfrgtjh");
        return user;
    }

    private void GetCartAndUserData(Cart cart, User user) {
        Order order = new Order();
        order.setTotalPrice(new BigDecimal(200.00));
        order.setPaid(true);
        order.setUser(user);

        Product product = new Product();
        product.setName("Lodowka");
        product.setPrice(new BigDecimal(2.00));
        product.setStock(100);
        Group group = new Group();
        group.setDescription("AGD");
        group.getProducts().add(product);
        product.setGroup(group);

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(10);
        orderItem.setPrice(new BigDecimal(20.0));
        orderItem.setOrder(order);

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);

        order.setItems(orderItems);

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        user.setOrders(orders);

        cart.setUser(user);

        List<Product> products = new ArrayList<>();
        products.add(product);

        group.setProducts(products);

        cart.setProducts(products);

        List<Cart> carts = new ArrayList<>();
        carts.add(cart);

        product.setCarts(carts);
        product.setOrderItems(orderItems);
    }
}
