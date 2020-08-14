package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exception.NotFoundException;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(final Long id) throws NotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product doesn't exist"));
    }

    public void deleteProduct(final Long id) {
        productRepository.deleteById(id);
    }

    public void createProduct(Product product) {
        saveProduct(product);
    }

    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(final Long id, final Product product) throws NotFoundException {
        Product productToUpdate = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product doesn't exist"));
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setAvailable(product.isAvailable());
        productToUpdate.setStock(product.getStock());
        productToUpdate.setNew(product.isNew());
        productToUpdate.setAgeRegulation(product.isAgeRegulation());
        productToUpdate.setGroup(product.getGroup());

        int position = productRepository.findAll().indexOf(productToUpdate);
        productRepository.findAll().set(position, productToUpdate);
        return saveProduct(productToUpdate);
    }

//    private List<ProductDto> generateProductsDto() {
//        List<ProductDto> productDtoList = new ArrayList<>();
//        ProductDto pencil = ProductDto.builder()
//                .id(3L)
//                .description("Majstersztyk długopis")
//                .groupDto(new GroupDto())
//                .name("Długopis")
//                .price(BigDecimal.valueOf(99.99))
//                .build();
//        ProductDto mouse = ProductDto.builder()
//                .id(2L)
//                .description("Pro head shots")
//                .groupDto(new GroupDto())
//                .name("Nimbus 2000")
//                .price(BigDecimal.valueOf(219.99))
//                .build();
//        ProductDto keyboard = ProductDto.builder()
//                .id(1L)
//                .description("Gamers keyboard")
//                .groupDto(new GroupDto())
//                .name("Samsung 4500")
//                .price(BigDecimal.valueOf(150.30))
//                .build();
//
//        productDtoList.add(pencil);
//        productDtoList.add(mouse);
//        productDtoList.add(keyboard);
//        return productDtoList;
//    }
}
