package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private BigDecimal totalPrice;
    private Integer quantity;
    private List<ProductDto> products;
    private UserDto user;
}
