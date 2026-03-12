package com.degenerate.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

    private Long code_product;

    private String name_product;

    private float price;

    private String section;
    
    private Long stock;

}
