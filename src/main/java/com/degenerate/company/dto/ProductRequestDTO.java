package com.degenerate.company.dto;

import lombok.Data;

@Data
public class ProductRequestDTO {
    
    private String name_product;
    
    private float price;
    
    private String section;
    
    private Long stock;

    
}
