package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.dto.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartMapper {
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    public Cart mapToCart(final CartDto cartDto){
        return new Cart(
                cartDto.getId(),
                cartDto.getTotalPrice(),
                cartDto.getQuantity(),
                productMapper.mapToProductList(cartDto.getProducts()),
                userMapper.mapToUser(cartDto.getUser())
        );
    }

    public CartDto mapToCartDto(final  Cart cart){
        return new CartDto(
                cart.getId(),
                cart.getTotalPrice(),
                cart.getQuantity(),
                productMapper.mapToProductDtoList(cart.getProducts()),
                userMapper.mapToUserDto(cart.getUser())
        );
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList){
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}

