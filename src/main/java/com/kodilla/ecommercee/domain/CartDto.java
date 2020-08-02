package com.kodilla.ecommercee.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private List<ProductDto> productList;
    private BigDecimal totalPrice;
    private int quantity;
    private long userId;
}
