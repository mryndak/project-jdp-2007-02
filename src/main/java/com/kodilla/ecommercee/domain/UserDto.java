package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
@Builder
public class UserDto {

    private long id;
    private String userName;
    private long status;
    private long userKey;
}


