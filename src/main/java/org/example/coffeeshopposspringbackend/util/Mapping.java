package org.example.coffeeshopposspringbackend.util;

import org.example.coffeeshopposspringbackend.entity.CustomerEntity;
import org.example.coffeeshopposspringbackend.entity.ProductEntity;
import org.example.coffeeshopposspringbackend.impl.CustomerDTO;
import org.example.coffeeshopposspringbackend.impl.ProductDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //matters of CustomerEntity and DTO
    public CustomerDTO convertToDTO(CustomerEntity customer){
        return modelMapper.map(customer, CustomerDTO.class);
    }
    public CustomerEntity convertToEntity(CustomerDTO dto){
        return modelMapper.map(dto, CustomerEntity.class);
    }
    public List<CustomerDTO> convertToDTO(List<CustomerEntity> customers){
        return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    //matters of ProductEntity and DTO
    public ProductEntity convertToProductEntity(ProductDTO productDTO){
        return modelMapper.map(productDTO, ProductEntity.class);
    }
    public ProductDTO convertToProductDTO(ProductEntity productEntity){
        return modelMapper.map(productEntity, ProductDTO.class);
    }
    public List<ProductDTO> convertProductToDTOList(List<ProductEntity> productEntities){
        return modelMapper.map(productEntities, new TypeToken<List<ProductDTO>>() {}.getType());
    }

}
