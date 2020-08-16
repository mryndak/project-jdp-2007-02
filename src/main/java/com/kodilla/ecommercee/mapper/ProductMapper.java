package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> productList) {
        return productList.stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }

    public Product mapToProduct(final ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .Stock(productDto.getStock())
                .isAvailable(productDto.isAvailable())
                .isNew(productDto.isNew())
                .ageRegulation(productDto.isAgeRegulation())
                .group(productDto.getGroup())
                .carts(productDto.getCarts())
                .orderItems(productDto.getOrderItems())
                .build();
    }

    public ProductDto mapToProductDto(final Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .Stock(product.getStock())
                .isAvailable(product.isAvailable())
                .isNew(product.isNew())
                .ageRegulation(product.isAgeRegulation())
                .group(product.getGroup())
                .carts(product.getCarts())
                .orderItems(product.getOrderItems())
                .build();
    }
}
