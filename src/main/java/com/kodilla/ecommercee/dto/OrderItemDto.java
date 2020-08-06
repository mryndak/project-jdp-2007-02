package com.kodilla.ecommercee.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDto {
    private Long id;
    private Long productId;
    private int quantity;
    private BigDecimal price;
}

