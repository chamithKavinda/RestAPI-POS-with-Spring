package org.example.coffeeshopposspringbackend.service;

import org.example.coffeeshopposspringbackend.dao.CustomerDao;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.impl.CustomerDTO;
import org.example.coffeeshopposspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService{
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        var customerEntity = mapping.convertToEntity(customerDTO);
        var savedCustomer = customerDao.save(customerEntity);
        if(savedCustomer == null){
            throw new DataPersistFailedException("Cannot save customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.convertToDTO(customerDao.findAll());
    }
}
