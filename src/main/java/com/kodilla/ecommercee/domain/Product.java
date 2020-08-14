package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;

    @NotNull
    @Column(name = "STOCK")
    private int Stock;

    @Column(name = "IS_AVAILABLE")
    private boolean isAvailable;

    @Column(name = "IS_NEW")
    private boolean isNew;

    @Column(name = "AGE_REGULATION")
    private boolean ageRegulation;

    @ManyToOne(optional = false,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @ManyToMany(
            targetEntity = Cart.class,
            cascade = CascadeType.PERSIST,
            mappedBy = "products",
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "CART_ID")
    private List<Cart> carts = new ArrayList<>();

    @OneToMany(
            targetEntity = OrderItem.class,
            mappedBy = "product",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "ORDER_ITEM_ID")
    private List<OrderItem> orderItems = new ArrayList<>();
}