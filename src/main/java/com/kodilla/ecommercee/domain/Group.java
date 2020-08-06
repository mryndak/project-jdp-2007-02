package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GROUPSy")
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name= "ID", unique = true)
    private Long id;

    @NotNull
    private String name;

//    @OneToMany(
//            targetEntity = Product.class,
//            mappedBy = "group",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    private List<Product> products = new ArrayList<>();

}