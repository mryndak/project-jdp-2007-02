package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.OrderItem;
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
    private User user;
    private BigDecimal totalPrice;
    private LocalDate dateOfOrder;
    private LocalDate dateOfShipment;
    private String deliveryMethod;
    private boolean isPaid;
    private boolean orderCompleted;
    private List<OrderItemDto> items;
    private String comment;
}

