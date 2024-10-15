package org.example.coffeeshopposspringbackend.service;

import org.example.coffeeshopposspringbackend.dto.OrderDTO;

public interface OrderService {
    String saveOrder(OrderDTO orderDTO);
}
