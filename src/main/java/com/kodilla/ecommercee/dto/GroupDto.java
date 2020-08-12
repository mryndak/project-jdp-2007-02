package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class GroupDto {
    private Long Id;
    private String name;
    private String description;
    private List<ProductDto> productDtoList;
}