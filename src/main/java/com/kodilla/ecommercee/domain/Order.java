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
    @Column(unique = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
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

