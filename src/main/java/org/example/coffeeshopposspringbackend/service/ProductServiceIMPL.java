package org.example.coffeeshopposspringbackend.service;

import org.example.coffeeshopposspringbackend.dao.CustomerDao;
import org.example.coffeeshopposspringbackend.dao.ProductDao;
import org.example.coffeeshopposspringbackend.entity.CustomerEntity;
import org.example.coffeeshopposspringbackend.entity.ProductEntity;
import org.example.coffeeshopposspringbackend.exception.CustomerNotFound;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.exception.ProductNotFound;
import org.example.coffeeshopposspringbackend.impl.ProductDTO;
import org.example.coffeeshopposspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ProductDTO> getAllProducts() {
        return mapping.convertToProductDTOList(productDao.findAll());
    }

    @Override
    public void updateProduct(String pro_id, ProductDTO incomeproduct) {
        Optional<ProductEntity> tmpproductEntity = productDao.findById(pro_id);

        if (!tmpproductEntity.isPresent()){
            throw new ProductNotFound("Product Not Found");
        }else {
            tmpproductEntity.get().setCategory(incomeproduct.getCategory());
            tmpproductEntity.get().setPrice(incomeproduct.getPrice());
            tmpproductEntity.get().setPro_name(incomeproduct.getPro_name());
            tmpproductEntity.get().setQuantity(incomeproduct.getQuantity());
            productDao.save(tmpproductEntity.get());
        }
    }
}
