package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
   List<ProductDto> getProducts();
   ProductDto getProduct(Long id) throws  ProductNotFoundException;
   void deleteProduct(Long id);
   void createProduct(ProductDto productDto);
   ProductDto updateProduct(Long id, ProductDto productDto) throws ProductNotFoundException;
}
