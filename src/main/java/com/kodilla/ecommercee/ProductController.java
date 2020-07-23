package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class ProductController {

    @GetMapping(value = "getProducts")
    public List<String> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getProduct")
    public String getProduct(@RequestParam Long productId) throws Exception {
        return "create product";
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) throws Exception{
        //delete product
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody String productDto) {
        //create product
    }

    @PutMapping(value = "updateProduct")
    public String updateProduct(@RequestBody String productDto) {
        return "update product";
    }
}
