package org.example.coffeeshopposspringbackend.service;

import org.example.coffeeshopposspringbackend.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();
}
