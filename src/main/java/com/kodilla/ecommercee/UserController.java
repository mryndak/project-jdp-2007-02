package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.UserDto;
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
                        .id(3)
                        .userName("Piotrek")
                        .status(1)
                        .userKey(59403)
                        .build(),
                UserDto.builder()
                        .id(2)
                        .userName("Admin")
                        .status(1)
                        .userKey(96997)
                        .build());
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return new UserDto(id, "Piotr", 1, 59403);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id,@RequestBody UserDto userDto) {
        return new UserDto(userDto.getId(), userDto.getUserName(), userDto.getStatus(), userDto.getUserKey());
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
    }
}

