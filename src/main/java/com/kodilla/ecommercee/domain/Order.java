package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
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
