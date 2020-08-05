package com.kodilla.ecommercee.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private List<ProductDto> productList;
    private BigDecimal totalPrice;
    private Integer quantity;
    private Long userId;
}
