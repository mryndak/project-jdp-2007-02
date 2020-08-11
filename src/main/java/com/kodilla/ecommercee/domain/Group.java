package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "GROUPS_PRODUCT")
public class Group {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> products = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
}
