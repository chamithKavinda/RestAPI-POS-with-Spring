package org.example.coffeeshopposspringbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.coffeeshopposspringbackend.dao.ProductDao;
import org.example.coffeeshopposspringbackend.entity.ProductEntity;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.impl.ProductDTO;
import org.example.coffeeshopposspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceIMPL implements ProductService {
    @Autowired
    private final ProductDao productDao;
    @Autowired
    private final Mapping mapping;
    @Override
    public void saveProduct(ProductDTO productDTO) {
        System.out.println("5");
        ProductEntity savedProduct =
                productDao.save(mapping.convertToProductEntity(productDTO));
        System.out.println("6");
        if(savedProduct == null ) {
            System.out.println("7");
            throw new DataPersistFailedException("Cannot data saved");
        }
    }
}
