package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Setter
@Table(name = "USERS")

public class User {
    @Id
    @GeneratedValue
    @Column(name= "ID", unique = true)
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private int status;

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

    @NotNull
    private boolean isBlocked;

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
    private List<Order> orders = new ArrayList<>();

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "CARTS_ID")
//    private Cart cart;
}
