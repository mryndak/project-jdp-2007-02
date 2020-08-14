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
public class ProductTestSuite {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;

    @Test
    public void testProductSave() {
        //Given
        Product product= new Product();
        Group group = new Group();

        product.setName("Zeszyt");
        product.setPrice(new BigDecimal(12));
        product.setStock(3);
        product.setGroup(group);

        group.setDescription("Papiernicze");

        //When
        productRepository.save(product);
        //Then
        Long productId = product.getId();
        Optional<Product> readProduct = productRepository.findById(productId);
        Assert.assertTrue(readProduct.isPresent());
        //CleanUp
        productRepository.deleteById(productId);
    }
    @Test
    public void testProductDelete(){

        User user = new User();
        user.setUserName("pablo");
        user.setStatus(UserStatus.TO_ACTIVATE);
        user.setUserKey(2L);
        user.setFirstName("Paweł");
        user.setLastName("Kowalski");
        user.setBirthDate(LocalDate.of(1993,2,2));
        user.setRegisterDate(LocalDate.now());
        user.setEmail("pablo@wp.pl");
        user.setCity("Wrocław");
        user.setPostCode("50-374");
        user.setStreet("Bierutowska");
        user.setHouseNr("235");
        user.setPhoneNumber("222-222-222");
        user.setLogin("paolo");
        user.setPassword("qwerty");

        List<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();

        Order order= new Order();
        order.setTotalPrice(new BigDecimal(22.3));
        order.setPaid(true);

        order.setItems(orderItems);
        order.setUser(user);
        user.getOrders().add(order);

        Product product= new Product();
        List<Product> products=new ArrayList<>();

        Group group = new Group();
        group.setDescription("Papiernicze");

//        List<Cart> carts=new ArrayList<>();
        Cart cart = new Cart();

        cart.setProducts(products);
        cart.setQuantity(12);
        cart.setTotalPrice(new BigDecimal(12));
        cart.setUser(user);

        product.getCarts().add(cart);

        orderItem.setProduct(product);
        orderItem.setQuantity(22);
        orderItem.setPrice(BigDecimal.valueOf(22.3));
        orderItem.setOrder(order);

        orderItems.add(orderItem);
        order.setItems(orderItems);

        product.setName("Zeszyt");
        product.setPrice(new BigDecimal(12));
        product.setStock(3);
        product.setGroup(group);
        group.getProducts().add(product);


        product.setOrderItems(orderItems);

        productRepository.save(product);
        Long productId = product.getId();
        Long orderItemId = orderItem.getId();
        Long userId = user.getId();
        Long cartId = cart.getId();

        //When
        productRepository.deleteById(productId);
        Optional<Product> readProduct = productRepository.findById(productId);
        Optional<OrderItem> readOrderItem = orderItemRepository.findById(orderItemId);
        Optional<Cart> readCart = cartRepository.findById(cartId);
        Optional<User> readUser = userRepository.findById(userId);
        //Then
        Assert.assertFalse(readProduct.isPresent());
        Assert.assertTrue(readCart.isPresent());
        Assert.assertTrue(readUser.isPresent());
        Assert.assertFalse(readOrderItem.isPresent());

        //CleanUp
        userRepository.deleteById(userId);
    }
    @Test
    public void testProductUpdate() {
        //Given
        Product product= new Product();
        Group group = new Group();

        product.setName("Zeszyt");
        product.setPrice(new BigDecimal(12));
        product.setStock(3);
        product.setGroup(group);

        group.setDescription("Papiernicze");
        productRepository.save(product);

        //When
        product.setName("Piornik");
        productRepository.save(product);
        //Then
        Long productId = product.getId();
        Product readProduct = productRepository.findById(productId).orElse(null);
        Assert.assertEquals(readProduct.getName(),"Piornik");
        //CleanUp
        productRepository.deleteById(productId);
    }
}
