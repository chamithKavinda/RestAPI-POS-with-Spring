package org.example.coffeeshopposspringbackend.service;

import org.example.coffeeshopposspringbackend.impl.ProductDTO;

import java.util.List;

public interface ProductService {
    void saveProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
}
