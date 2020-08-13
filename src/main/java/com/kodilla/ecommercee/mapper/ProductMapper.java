package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public final class ProductMapper {
//    private GroupMapper groupMapper;

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
        return new Product();

//        return new Product(
//                productDto.getId(),
//                productDto.getName(),
//                productDto.getDescription(),
//                productDto.getPrice(),
//                groupMapper.mapToGroup(productDto.getGroupDto())
//        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto();

//        return new ProductDto(
//                product.getId(),
//                product.getName(),
//                product.getDescription(),
//                product.getPrice()
//                groupMapper.mapToGroupDto(product.getGroup())
//        );
    }
}
