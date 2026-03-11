package com.degenerate.company.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.degenerate.company.dto.ProductRequestDTO;
import com.degenerate.company.dto.ProductResponseDTO;
import com.degenerate.company.entity.Product;
import com.degenerate.company.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();

        product.setName_product(productRequestDTO.getName_product());
        product.setPrice(productRequestDTO.getPrice());
        product.setSection(productRequestDTO.getSection());
        product.setStock(productRequestDTO.getStock());

        Product savedProduct = productRepository.save(product);

        return productToResponseDTO(savedProduct);
}
     private ProductResponseDTO productToResponseDTO(Product product) {

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setCode_product(product.getCode_product());
        dto.setName_product(product.getName_product());
        dto.setPrice(product.getPrice());
        dto.setSection(product.getSection());
        dto.setStock(product.getStock());

        return dto;
    }

    public Optional<ProductResponseDTO> getProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            ProductResponseDTO response = new ProductResponseDTO();
            response.setCode_product(product.getCode_product());
            response.setName_product(product.getName_product());
            response.setPrice(product.getPrice());
            response.setSection(product.getSection());
            response.setStock(product.getStock());

            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }
}
