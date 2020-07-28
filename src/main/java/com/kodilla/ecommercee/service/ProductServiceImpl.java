package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private List<ProductDto> initialProductDtoList = generateProductsDto();
    @Override
    public List<ProductDto> getProducts() {
        return initialProductDtoList;
    }

    @Override
    public ProductDto getProduct(Long id) throws ProductNotFoundException {
        return initialProductDtoList.stream()
                .filter(productDto -> productDto.getId().equals(id))
                .findFirst().orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteProduct(Long id) {
        initialProductDtoList.removeIf(productDto -> productDto.getId().equals(id));
    }

    @Override
    public void createProduct(ProductDto productDto) {
        initialProductDtoList.add(productDto);
    }

    @Override
    public ProductDto updateProduct(Long id,ProductDto productDto) throws ProductNotFoundException {
        ProductDto productDtoToUpdate = initialProductDtoList.stream()
                .filter(prodDto -> prodDto.getId().equals(id))
                .findFirst().orElseThrow(ProductNotFoundException::new);
        productDtoToUpdate.setDescription(productDto.getDescription());
        productDtoToUpdate.setGroupId(productDto.getGroupId());
        productDtoToUpdate.setName(productDto.getName());
        productDtoToUpdate.setPrice(productDto.getPrice());
        int position = initialProductDtoList.indexOf(productDtoToUpdate);
        initialProductDtoList.set(position, productDtoToUpdate);
        return productDtoToUpdate;
    }

    private List<ProductDto> generateProductsDto() {
        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto pencil = ProductDto.builder()
                .id(3L)
                .description("Majstersztyk długopis")
                .groupId(1L)
                .name("Długopis")
                .price(BigDecimal.valueOf(99.99))
                .build();
        ProductDto mouse = ProductDto.builder()
                .id(2L)
                .description("Pro head shots")
                .groupId(2L)
                .name("Nimbus 2000")
                .price(BigDecimal.valueOf(219.99))
                .build();
        ProductDto keyboard = ProductDto.builder()
                .id(1L)
                .description("Gamers keyboard")
                .groupId(3L)
                .name("Samsung 4500")
                .price(BigDecimal.valueOf(150.30))
                .build();
        productDtoList.add(pencil);
        productDtoList.add(mouse);
        productDtoList.add(keyboard);
        return productDtoList;
    }
}
