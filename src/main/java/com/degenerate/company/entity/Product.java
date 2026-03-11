package com.degenerate.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_product")
    private Long code_product;

    @Column(name = "name_product")
    private String name_product;

    @Column(name = "price")
    private float price;
    
    @Column(name = "section")
    private String section;
    
    
    @Column(name = "stock")
    private Long stock;
    
}
