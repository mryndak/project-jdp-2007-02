package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor

public class OrderMapper {

    private final OrderItemMapper orderItemMapper;

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getUser(),
                orderDto.getTotalPrice(),
                orderDto.getDateOfOrder(),
                orderDto.getDateOfShipment(),
                orderDto.getDeliveryMethod(),
                orderDto.isPaid(),
                orderDto.isOrderCompleted(),
                orderItemMapper.mapToOrderItemList(orderDto.getItems()),
                orderDto.getComment());
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser(),
                order.getTotalPrice(),
                order.getDateOfOrder(),
                order.getDateOfShipment(),
                order.getDeliveryMethod(),
                order.isPaid(),
                order.isOrderCompleted(),
                orderItemMapper.mapToOrderItemDtoList(order.getItems()),
                order.getComment());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }

    public List<Order> mapToOrderList(final List<OrderDto> orderDtoList) {
        return orderDtoList.stream()
                .map(this::mapToOrder)
                .collect(Collectors.toList());
    }
}
