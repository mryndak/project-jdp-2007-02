package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperAllData {

    public User mapToUser(final UserDto userDto) {
        return new User(
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
                userDto.getPassword());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getStatus(),
                user.getUserKey(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getRegisterDate(),
                user.getEmail(),
                user.getCity(),
                user.getPostCode(),
                user.getStreet(),
                user.getHouseNr(),
                user.getApartmentNr(),
                user.getPhoneNumber(),
                user.isBlocked(),
                user.getLogin(),
                user.getPassword());
    }

    public List<UserDto> mapToUserDtoList(final List<User> usersList) {
        return usersList.stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getUserName(),
                        user.getStatus(),
                        user.getUserKey(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getBirthDate(),
                        user.getRegisterDate(),
                        user.getEmail(),
                        user.getCity(),
                        user.getPostCode(),
                        user.getStreet(),
                        user.getHouseNr(),
                        user.getApartmentNr(),
                        user.getPhoneNumber(),
                        user.isBlocked(),
                        user.getLogin(),
                        user.getPassword()))
                .collect(Collectors.toList());
    }
}
