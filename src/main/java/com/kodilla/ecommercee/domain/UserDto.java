package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private int status;
    private int userKey;
    private String firstName;
    private String lastName;
    private int age;
    private String city;
    private String postCode;
    private String houseNumber;
    private String apartmentNumber;
    private String password;
}
