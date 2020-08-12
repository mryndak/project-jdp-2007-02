package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class GroupDto {
    private Long Id;
    private String description;
    private List<Product> products = new ArrayList<>();
}