package org.example.coffeeshopposspringbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.coffeeshopposspringbackend.dao.OrderDAO;
import org.example.coffeeshopposspringbackend.dao.ProductDao;
import org.example.coffeeshopposspringbackend.dto.OrderDTO;
import org.example.coffeeshopposspringbackend.service.OrderService;
import org.example.coffeeshopposspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private final OrderDAO orderDAO;

    @Autowired
    private final ProductDao productDao;

    @Autowired
    private Mapping mapping;
    @Override
    public String saveOrder(OrderDTO orderDTO) {
        return null;
    }

    private String generateOrderID() {
        if (orderDAO.count() == 0) {
            return "O001";
        } else {
            String lastId = orderDAO.findAll().get(orderDAO.findAll().size() - 1).getOrderId();
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            if (newId < 10) {
                return "O00" + newId;
            } else if (newId < 100) {
                return "O0" + newId;
            } else {
                return "O" + newId;
            }
        }
    }
}
