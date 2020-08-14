package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Builder
@Table(name = "USERS")

public class User {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @NotNull
    private Long userKey;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private LocalDate registerDate;

    @NotNull
    private String email;

    @NotNull
    private String city;

    @NotNull
    private String postCode;

    @NotNull
    private String street;

    @NotNull
    private String houseNr;

    private String apartmentNr;

    @NotNull
    private String phoneNumber;

    @Column(unique = true)
    @NotNull
    private String login;

    @NotNull
    private String password;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "ORDER_ID")
    private List<Order> orders = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CARTS_ID")
    private Cart cart;
}
