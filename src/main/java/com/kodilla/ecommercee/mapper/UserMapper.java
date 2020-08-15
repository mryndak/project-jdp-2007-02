package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final OrderMapper orderMapper;
    private final CartMapper cartMapper;

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
                userDto.getLogin(),
                userDto.getPassword(),
                orderMapper.mapToOrderList(userDto.getOrders()),
                cartMapper.mapToCart(userDto.getCartDto())
        );
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
                user.getLogin(),
                user.getPassword(),
                orderMapper.mapToOrderDtoList(user.getOrders()),
                cartMapper.mapToCartDto(user.getCart())
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> usersList) {
        return usersList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    public List<User> mapToUserList(final List<UserDto> usersDtoList) {
        return usersDtoList.stream()
                .map(this::mapToUser)
                .collect(Collectors.toList());
    }
}
