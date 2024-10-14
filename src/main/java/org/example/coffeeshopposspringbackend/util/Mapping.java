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
    public List<CustomerDTO> convertToCustomerDTO(List<CustomerEntity> customers){
        return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    //matters of ProductEntity and DTO
    public ProductDTO convertToDTO(ProductEntity product){
        return modelMapper.map(product, ProductDTO.class);
    }
    public ProductEntity convertToEntity(ProductDTO dto){
        return modelMapper.map(dto, ProductEntity.class);
    }
    public List<ProductDTO> convertToDTOList(List<ProductEntity> products){
        return modelMapper.map(products, new TypeToken<List<ProductDTO>>() {}.getType());
    }


}
