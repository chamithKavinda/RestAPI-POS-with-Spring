package org.example.coffeeshopposspringbackend.service.impl;

import org.example.coffeeshopposspringbackend.customeobj.impl.ProductErrorResponse;
import org.example.coffeeshopposspringbackend.customeobj.ProductResponse;
import org.example.coffeeshopposspringbackend.dao.ProductDao;
import org.example.coffeeshopposspringbackend.entity.ProductEntity;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.exception.ProductNotFound;
import org.example.coffeeshopposspringbackend.dto.ProductDTO;
import org.example.coffeeshopposspringbackend.service.ProductService;
import org.example.coffeeshopposspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIMPL implements ProductService {
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

    @Override
    public ProductResponse getSelectedProduct(String pro_id) {
        if(productDao.existsById(pro_id)){
            System.out.println("2");
            return mapping.convertToProductDTO(productDao.getReferenceById(pro_id));
        }else {
            return new ProductErrorResponse(0,"Product not found");
        }
    }

    @Override
    public void deleteProduct(String pro_id) {
        Optional<ProductEntity> findId = productDao.findById(pro_id);
        if(!findId.isPresent()){
            throw new ProductNotFound("Product not found");
        }else {
            productDao.deleteById(pro_id);
        }
    }


}
