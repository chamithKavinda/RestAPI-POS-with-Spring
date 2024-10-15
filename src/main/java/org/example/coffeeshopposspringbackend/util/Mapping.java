package org.example.coffeeshopposspringbackend.util;

import org.example.coffeeshopposspringbackend.dto.OrderDTO;
import org.example.coffeeshopposspringbackend.dto.OrderDetailDTO;
import org.example.coffeeshopposspringbackend.entity.CustomerEntity;
import org.example.coffeeshopposspringbackend.entity.OrderDetailsEntity;
import org.example.coffeeshopposspringbackend.entity.OrderEntity;
import org.example.coffeeshopposspringbackend.entity.ProductEntity;
import org.example.coffeeshopposspringbackend.dto.CustomerDTO;
import org.example.coffeeshopposspringbackend.dto.ProductDTO;
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
    public ProductDTO convertToProductDTO(ProductEntity product){
        return modelMapper.map(product, ProductDTO.class);
    }
    public ProductEntity convertToEntity(ProductDTO dto){
        return modelMapper.map(dto, ProductEntity.class);
    }
    public List<ProductDTO> convertToProductDTOList(List<ProductEntity> products){
        return modelMapper.map(products, new TypeToken<List<ProductDTO>>() {}.getType());
    }

    //matters of OrderEntity and DTO
    public OrderEntity convertToOrderEntity(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderDTO.getOrderId());
        orderEntity.setOrderDateTime(orderDTO.getOrderDateTime());
        CustomerEntity customer = new CustomerEntity();
        customer.setCustContact(orderDTO.getCustContact());
        orderEntity.setCustomer(customer);
        return orderEntity;
    }

    //matters of OrderDetailsEntity and DTO
    public OrderDetailsEntity convertToOrderDetailEntity(OrderDetailDTO dto){
        return modelMapper.map(dto, OrderDetailsEntity.class);
    }
}
