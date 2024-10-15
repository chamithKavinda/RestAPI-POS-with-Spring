package org.example.coffeeshopposspringbackend.service;

import org.example.coffeeshopposspringbackend.dto.OrderDTO;
import org.example.coffeeshopposspringbackend.dto.OrderDetailDTO;

import java.util.List;

public interface OrderService {
    String saveOrder(OrderDTO orderDTO);

}
