package org.example.coffeeshopposspringbackend.service;

import org.example.coffeeshopposspringbackend.customeobj.ProductResponse;
import org.example.coffeeshopposspringbackend.impl.ProductDTO;

import java.util.List;

public interface ProductService {
    void saveProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    void updateProduct(String pro_id, ProductDTO product);
    ProductResponse getSelectedProduct(String pro_id);
}
