package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderItem;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.OrderItemDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderItemMapper {

    public List<OrderItem> mapToOrderItemList(final List<OrderItemDto> orderItemDto) {
        return new ArrayList();
    }
    public List<OrderItemDto> mapToOrderItemDtoList(final List<OrderItem> orderItem) {
        return new ArrayList();
    }
}