package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public List<ProductDto> mapToProductDtoList(final List<Product> productList){
        return new ArrayList<>();
    }
    public List<Product> mapToProductList(final List<ProductDto> productList){
        return new ArrayList<>();
    }
}

