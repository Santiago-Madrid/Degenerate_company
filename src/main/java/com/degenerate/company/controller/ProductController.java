package com.degenerate.company.controller;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.degenerate.company.dto.ProductRequestDTO;
import com.degenerate.company.dto.ProductResponseDTO;
import com.degenerate.company.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    
    private final ProductService productService;

    @PostMapping 
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        try {
            ProductResponseDTO response = productService.createProduct(productRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/{code_product}")
    public ResponseEntity<Optional<ProductResponseDTO>> getProduct(@PathVariable Long code_product) {
        try{
            Optional<ProductResponseDTO> response = productService.getProduct(code_product); 
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    
}
