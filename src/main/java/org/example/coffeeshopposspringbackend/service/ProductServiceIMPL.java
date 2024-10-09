package org.example.coffeeshopposspringbackend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.coffeeshopposspringbackend.customeobj.ProductErrorResponse;
import org.example.coffeeshopposspringbackend.customeobj.ProductResponse;
import org.example.coffeeshopposspringbackend.dao.ProductDao;
import org.example.coffeeshopposspringbackend.entity.ProductEntity;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.impl.ProductDTO;
import org.example.coffeeshopposspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceIMPL implements ProductService {
    @Autowired
    private final ProductDao productDao;
    @Autowired
    private final Mapping mapping;
    @Override
    public void saveProduct(ProductDTO productDTO) {
        ProductEntity savedProduct =
                productDao.save(mapping.convertToProductEntity(productDTO));
        if(savedProduct == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> getAllProducts = productDao.findAll();
        return mapping.convertProductToDTOList(getAllProducts);
    }


}
