package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDto {
    private Long id;
    private Product product;
    private int quantity;
    private BigDecimal price;
    private Order order;
}

