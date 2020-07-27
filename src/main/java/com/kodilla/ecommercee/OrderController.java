package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    @GetMapping
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable Long id){
        return new OrderDto(id,2L, new Cart());
    }

    @DeleteMapping
    public void deleteOrder(@RequestParam Long id){
        System.out.println("Delete order(id="+id+")");
    }

    @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto) {
        System.out.println(orderDto.getId()+"\n"+orderDto.getUserId()+"\n"+orderDto.getCart().getProducts()+" "+orderDto.getCart().getTotalPrice());
    }

    @PutMapping
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        System.out.println(orderDto.getId()+"\n"+orderDto.getUserId()+"\n"+orderDto.getCart().getProducts()+" "+orderDto.getCart().getTotalPrice());
        return new OrderDto(orderDto.getId(), orderDto.getUserId(), orderDto.getCart());
    }
}
