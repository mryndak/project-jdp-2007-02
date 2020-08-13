package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exception.NotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    public List<OrderDto> getOrders()
    {
        return orderMapper.mapToOrderDtoList(orderService.getOrders());
    }
    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable Long id) throws NotFoundException {
        return orderMapper.mapToOrderDto(orderService.getOrder(id));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

    @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderMapper.mapToOrder(orderDto));
    }

    @PutMapping("/{id}")
    public OrderDto updateOrder(@PathVariable Long id,@RequestBody OrderDto orderDto) throws NotFoundException {
        return orderMapper.mapToOrderDto(orderService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }
}

