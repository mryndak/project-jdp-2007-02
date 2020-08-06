package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exception.NotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserMapper mapper;

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

