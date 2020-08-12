package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderItem;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.OrderItemDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderItemMapper {

//    public List<OrderItem> mapToOrderItemList(final List<OrderItemDto> orderItemDto) {
//        return new ArrayList();
//    }
//    public List<OrderItemDto> mapToOrderItemDtoList(final List<OrderItem> orderItem) {
//        return new ArrayList();
//    }

    public OrderItem mapToOrderItem(final OrderItemDto orderItemDto) {
        return new OrderItem(
                orderItemDto.getId(),
                orderItemDto.getProduct(),
                orderItemDto.getQuantity(),
                orderItemDto.getPrice(),
                orderItemDto.getOrder());
    }

    public OrderItemDto mapToOrderItemDto(final OrderItem orderItem) {
        return new OrderItemDto(
                orderItem.getId(),
                orderItem.getProduct(),
                orderItem.getQuantity(),
                orderItem.getPrice(),
                orderItem.getOrder());
    }

    public List<OrderItemDto> mapToOrderItemDtoList(final List<OrderItem> orderItemList) {
        return orderItemList.stream()
                .map(this::mapToOrderItemDto)
                .collect(Collectors.toList());
    }

    public List<OrderItem> mapToOrderItemList(final List<OrderItemDto> orderItemDtoList) {
        return orderItemDtoList.stream()
                .map(this::mapToOrderItem)
                .collect(Collectors.toList());
    }
}