package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private User user;
    @NotNull
    private BigDecimal totalPrice;
    private LocalDate dateOfOrder;
    private LocalDate dateOfShipment;
    private String deliveryMethod;
    @NotNull
    private boolean isPaid;
    private boolean isOrderCompleted;
    @OneToMany(
            targetEntity = OrderItem.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "order"
    )
    @NotNull
    private List<OrderItem> items;
    private String comment;
}