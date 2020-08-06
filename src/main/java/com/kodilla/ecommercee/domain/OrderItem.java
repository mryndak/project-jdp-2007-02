package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private Long productId;
    @NotNull
    private int quantity;
    @NotNull
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @NotNull
    private Order order;

}

