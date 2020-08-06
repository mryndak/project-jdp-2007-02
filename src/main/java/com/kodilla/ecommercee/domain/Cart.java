package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CARTS")
public class Cart {

    private Long id;
    private BigDecimal totalPrice;
    private Integer quantity;
    // ZAKOMENTOWANE Z UWAGI NA BRAK KLAS (OBIEKTÓW) PRODUCT w drzewie master
//    private Product product;
//    private List<Product> products = new ArrayList<>();

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "CART_ID")
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

//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
//    public List<Product> getProductList() {
//        return products;
//    }

    @NotNull
    public User user;

//@Id
//@GeneratedValue
//@NotNull
//@Column(name = "CART_ID", unique = true)
//    private Long id;
//
//    @NotNull
//    @Column(name = "TOTAL_PRICE")
//    private BigDecimal totalPrice;
//
//    @NotNull
//    @Column(name = "QUANTITY")
//    private Integer quantity;
//
//    @NotNull
//    private User user;
}
