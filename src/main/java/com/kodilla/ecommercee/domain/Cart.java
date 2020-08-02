package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    //    private List<Product> productList;
    private BigDecimal totalPrice;
    private int quantity;
    private long userId;
}
