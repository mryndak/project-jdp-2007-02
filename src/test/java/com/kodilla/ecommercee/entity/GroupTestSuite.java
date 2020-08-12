package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupTestSuite {
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testGroupSave() {
        //Given
        Group group = new Group();
        group.setName("Keyboards");
        //When
        groupRepository.save(group);
        //Than
        Optional<Group> groupOptional = groupRepository.findById(group.getId());
        Assert.assertTrue(groupOptional.isPresent());
        //CleanUp
        groupRepository.deleteById(group.getId());
    }

    @Test
    public void testGroupDelete() {
        //Given
        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        productList.add(product);
        Group group = new Group();
        group.setName("Keyboard");
        group.setProducts(productList);
        product.setGroup(group);
        product.setName("product");
        product.setPrice(new BigDecimal(10.99));
        product.setStock(30);
        //When
        productRepository.save(product);
        groupRepository.save(group);
        groupRepository.delete(group);
        Optional<Group> groupOptional = groupRepository.findById(group.getId());
        Optional<Product> productOptional = productRepository.findById(product.getId());
        //Then
        Assert.assertTrue(groupOptional.isPresent());
        Assert.assertTrue(productOptional.isPresent());
        //CleanUp
        productRepository.deleteById(product.getId());
    }

    @Test
    public void testGroupUpdate() {
        //Given
        Group group = new Group();
        group.setName("Keyboard");
        //When
        groupRepository.save(group);
        group.setName("Gaming Mouse");
        groupRepository.save(group);
        //Than
        Group groupOptional = groupRepository.findById(group.getId()).orElse(null);
        Assert.assertEquals("Gaming Mouse", groupOptional.getName());
        Assert.assertNotEquals("Keyboard", groupOptional.getName());
        //CleanUp
        groupRepository.deleteById(group.getId());
    }
}
