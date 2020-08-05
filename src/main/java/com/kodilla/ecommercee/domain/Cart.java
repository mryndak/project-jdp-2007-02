package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Long id;
    //    private List<Product> productList;
    private BigDecimal totalPrice;
    private Integer quantity;
    private Long userId;
}
