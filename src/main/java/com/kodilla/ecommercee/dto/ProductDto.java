package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.OrderItem;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int Stock;
    private boolean isAvailable;
    private boolean isNew;
    private boolean ageRegulation;
    private Group group;
    private List<Cart> carts = new ArrayList<>();
    private List<OrderItem> orderItems = new ArrayList<>();
}
