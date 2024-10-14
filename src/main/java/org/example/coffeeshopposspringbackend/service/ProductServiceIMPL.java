package org.example.coffeeshopposspringbackend.service;

import org.example.coffeeshopposspringbackend.dao.CustomerDao;
import org.example.coffeeshopposspringbackend.dao.ProductDao;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.impl.ProductDTO;
import org.example.coffeeshopposspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceIMPL implements ProductService{
    @Autowired
    private ProductDao productDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveProduct(ProductDTO productDTO) {
        var productEntity = mapping.convertToEntity(productDTO);
        var savedProduct = productDao.save(productEntity);
        if(savedProduct == null){
            throw new DataPersistFailedException("Cannot save product");
        }
    }
}
