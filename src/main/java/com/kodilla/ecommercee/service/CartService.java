package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exception.NotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public Cart getCart(final Long id){
        return cartRepository.findById(id).orElseThrow(() -> new NotFoundException("Cart not found"));
    }

    public void deleteCart(final Long id)
    {
        cartRepository.deleteById(id);
    }

    public Cart saveCart(final Cart cart){
        return cartRepository.save(cart);
    }

    public void createCart(Cart cart){
        cartRepository.save(cart);
    }

    public void addProductToCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found"));
        cart.getProducts().add(product);
        cartRepository.save(cart);
    }

    public void removeProductFromCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found"));
        cart.getProducts().remove(product);
        cartRepository.save(cart);
    }
}

