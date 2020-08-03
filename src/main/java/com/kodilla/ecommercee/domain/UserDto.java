package com.kodilla.ecommercee.domain;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class UserDto {
    private long id;
    private String userName;
    private long status;
    private long userKey;
}

