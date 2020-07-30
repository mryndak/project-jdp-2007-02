package com.kodilla.ecommercee.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private Long userId;
    private BigDecimal totalPrice;
    private LocalDate dateOfOrder;
    private LocalDate dateOfShipment;
    private String deliveryMethod;
    private boolean isPaid;
    private boolean orderCompleted;
    private List<OrderItem> items;
    private String comment;
}
