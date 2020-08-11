package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.exception.NotFoundException;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(final Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found"));
    }

    public void deleteOrder(final Long id) {
        orderRepository.deleteById(id);
    }

    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }
}
