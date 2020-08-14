package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public final class ProductMapper {
    private final GroupMapper groupMapper;
    private final CartMapper cartMapper;
    private final OrderItemMapper orderItemMapper;


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
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getStock(),
                productDto.isAvailable(),
                productDto.isNew(),
                productDto.isAgeRegulation(),
                groupMapper.mapToGroup(productDto.getGroupDto()),
                cartMapper.mapToCartList(productDto.getCartsDto()),
                orderItemMapper.mapToOrderItemList(productDto.getOrderItemsDto()));
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.isAvailable(),
                product.isNew(),
                product.isAgeRegulation(),
                groupMapper.mapToGroupDto(product.getGroup()),
                cartMapper.mapToCartDtoList(product.getCarts()),
                orderItemMapper.mapToOrderItemDtoList(product.getOrderItems()));
    }
}
