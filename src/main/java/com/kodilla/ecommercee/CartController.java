package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.exception.NotFoundException;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee")
public class CartController {

    @RequestMapping(method = RequestMethod.GET, value = "getCarts")
    public List<CartDto> getCarts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(@RequestBody CartDto cartDto) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public CartDto getCart(@RequestParam Long id) throws NotFoundException {
        return new CartDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCart")
    public void deleteCart(@RequestParam Long id) {
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "addProductToCart")
//    public void addProductToCart(long id, int quantity) {
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProductFromCart")
//    public void deleteProductFromCart(long id, int quantity) {
//    }

}
