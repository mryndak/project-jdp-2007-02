package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @GetMapping
    public List<UserDto> getUsers() {
        return Arrays.asList(
                UserDto.builder()
                        .id(3L)
                        .userName("Piotrek")
                        .status(1)
                        .userKey(59403L)
                        .build(),
                UserDto.builder()
                        .id(2L)
                        .userName("Admin")
                        .status(1)
                        .userKey(96997L)
                        .build());
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return new UserDto();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id,@RequestBody UserDto userDto) {
        return new UserDto(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getStatus(),
                userDto.getUserKey(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getBirthDate(),
                userDto.getRegisterDate(),
                userDto.getEmail(),
                userDto.getCity(),
                userDto.getPostCode(),
                userDto.getStreet(),
                userDto.getHouseNr(),
                userDto.getApartmentNr(),
                userDto.getPhoneNumber(),
                userDto.isBlocked(),
                userDto.getLogin(),
                userDto.getPassword()
        );
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
    }
}

