package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    @NotNull
    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToMany
    @JoinColumn(name = "PRODUCT_ID")
    public List<Product> products = new ArrayList<>();

    @OneToOne
    @NotNull
    @JoinColumn(name = "USER_ID")
    public User user;
}
