package com.kodilla.ecommercee.exception;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException() {
        super("Product not found");
    }
}
