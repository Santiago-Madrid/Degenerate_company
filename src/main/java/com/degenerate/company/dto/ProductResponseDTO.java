package com.degenerate.company.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long code_product;

    private String name_product;

    private float price;

    private String section;
    
    private Long stock;
}
