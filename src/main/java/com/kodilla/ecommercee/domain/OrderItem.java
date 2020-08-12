package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="product")
    @NotNull
    private Product product;
    @NotNull
    private int quantity;
    @NotNull
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @NotNull
    private Order order;
}

