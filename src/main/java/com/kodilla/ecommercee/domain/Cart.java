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

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CARTS")
public class Cart {
    private Long id;
    private BigDecimal totalPrice;
    private Integer quantity;

    // Czekam na zmergowanie klas USER i PRODUCTS oraz stworzenie encji
//    private User user;
//    private Product product;
//    private List<Product> products = new ArrayList<>();

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
//    public List<Product> getProductList() {
//        return products;
//    }

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

//    @NotNull
//    @Column(name = "USER")
////    @OneToOne // adnotacja w klasie User
//    public User getUser() {
//        return user;
//    }
}
