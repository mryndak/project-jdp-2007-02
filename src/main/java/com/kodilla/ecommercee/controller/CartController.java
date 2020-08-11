package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.exception.NotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService service;
    private final CartMapper mapper;

    @GetMapping
    public List<CartDto> getCarts() {
        return mapper.mapToCartDtoList(service.getCarts());
    }

    @PostMapping
    public void createCart(@RequestBody CartDto cartDto) {
        service.createCart(mapper.mapToCart(cartDto));
    }

    @GetMapping("/{id}")
    public CartDto getCart(@PathVariable Long id) throws NotFoundException {
        return mapper.mapToCartDto(service.getCart(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        service.deleteCart(id);
    }

    @PutMapping("/{id}")
    public CartDto updateCart(@PathVariable Long id, @RequestBody CartDto cartDto) {
        return mapper.mapToCartDto(service.saveCart(mapper.mapToCart(cartDto)));
    }

    @PutMapping("/cart:{cartId}&product:{productId}")
    public void addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        service.addProductToCart(cartId, productId);
    }

    @DeleteMapping("/cart:{cartId}&product:{productId}")
    public void removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        service.removeProductFromCart(cartId, productId);
    }
}

