package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperBasicData {

    public User mapToUser(final UserDto userDto) {
        return User.builder()
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .registerDate(userDto.getRegisterDate())
                .status(userDto.getStatus())
                .isBlocked(userDto.isBlocked())
                .build();
    }

    public UserDto mapToUserDto(final User user) {
        return UserDto.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .registerDate(user.getRegisterDate())
                .status(user.getStatus())
                .isBlocked(user.isBlocked())
                .build();
    }

    public List<UserDto> mapToUserDtoList(final List<User> usersList) {
        return usersList.stream().map(u -> UserDto.builder()
                .userName(u.getUserName())
                .email(u.getEmail())
                .registerDate(u.getRegisterDate())
                .status(u.getStatus())
                .isBlocked(u.isBlocked())
                .build())
                .collect(Collectors.toList());
    }
}
