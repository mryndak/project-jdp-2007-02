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
    @Column(name = "PRODUCT_ID", unique = true)
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "products",
            fetch = FetchType.LAZY
    )
    @Column(name = "CART_ID")
    private List<Cart> carts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ORDER_ITEM_ID")
    private OrderItem orderItem;
}