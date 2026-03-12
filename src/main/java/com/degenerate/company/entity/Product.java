package com.degenerate.company.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeProduct;
    private String nameProduct;
    private float price;
    private String section;
    private int stock;
}


