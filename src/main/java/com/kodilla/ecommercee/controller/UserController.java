package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exception.NotFoundException;
import com.kodilla.ecommercee.mapper.usermapper.UserMapperAllData;
import com.kodilla.ecommercee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final UserMapperAllData mapper;

    @GetMapping
    public List<UserDto> getUsers() {
        return mapper.mapToUserDtoList(service.getUsers());
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable final Long id) throws NotFoundException {
        return mapper.mapToUserDto(service.getUser(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable final Long id) {
        service.deleteUser(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) throws NotFoundException {
        return mapper.mapToUserDto(service.saveUser(mapper.mapToUser(userDto)));
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        service.createUser(mapper.mapToUser(userDto));
    }
}