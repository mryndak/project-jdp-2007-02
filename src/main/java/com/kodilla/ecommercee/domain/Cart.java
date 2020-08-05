package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CARTS")
public class Cart {
    private Long id;
    //    private List<Product> productList;
    private BigDecimal totalPrice;
    private Integer quantity;
    private Long userId;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @NotNull
    @Column(name = "TOTAL_PRICE")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @NotNull
    @Column(name = "QUANTITY")
    public Integer getQuantity() {
        return quantity;
    }

    @NotNull
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }
}
