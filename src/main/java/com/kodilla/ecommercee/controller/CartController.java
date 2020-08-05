package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/carts")
public class CartController {

    @GetMapping
    public List<CartDto> getCarts() {
        return new ArrayList<>();
    }

    @PostMapping
    public void createCart(@RequestBody CartDto cartDto) {
    }

    @GetMapping("/{id}")
    public CartDto getCart(@PathVariable Long id) throws NotFoundException {
        return new CartDto();
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "addProductToCart")
//    public void addProductToCart(long id, int quantity) {
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProductFromCart")
//    public void deleteProductFromCart(long id, int quantity) {
//    }

}
