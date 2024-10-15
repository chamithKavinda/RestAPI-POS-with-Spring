package org.example.coffeeshopposspringbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.coffeeshopposspringbackend.dao.OrderDAO;
import org.example.coffeeshopposspringbackend.dao.ProductDao;
import org.example.coffeeshopposspringbackend.dto.OrderDTO;
import org.example.coffeeshopposspringbackend.dto.OrderDetailDTO;
import org.example.coffeeshopposspringbackend.entity.OrderDetailsEntity;
import org.example.coffeeshopposspringbackend.entity.OrderEntity;
import org.example.coffeeshopposspringbackend.entity.ProductEntity;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.exception.ProductNotFound;
import org.example.coffeeshopposspringbackend.service.OrderService;
import org.example.coffeeshopposspringbackend.util.DateTime;
import org.example.coffeeshopposspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("7");
        orderDTO.setOrderId(generateOrderID());
        System.out.println("8");
        orderDTO.setOrderDateTime(DateTime.getCurrentDateTime());
        System.out.println("9");
        OrderEntity orderEntity = mapping.convertToOrderEntity(orderDTO);

        System.out.println("10");
        List<OrderDetailsEntity> orderDetailEntities = orderDTO.getOrderDetails().stream().map(detail -> {
                    System.out.println("11");
                    OrderDetailsEntity orderDetailEntity = mapping.convertToOrderDetailEntity(detail);
                    System.out.println("12");
                    orderDetailEntity.setOrder(orderEntity);
                    System.out.println("13");
                    System.out.println(orderDetailEntity);
                    return orderDetailEntity;
                })
                .collect(Collectors.toList());

        System.out.println("14");
        orderEntity.setOrderDetails(orderDetailEntities);
        System.out.println("15");
        boolean allItemsUpdated = orderDTO.getOrderDetails().stream().allMatch(this::updateItemQty);
        System.out.println("22");
        if (allItemsUpdated) {
            System.out.println("23");
            orderDAO.save(orderEntity);
            System.out.println("24");
            return "Order placed successfully";
        } else {
            throw new DataPersistFailedException("place order failed");
        }
    }

    private boolean updateItemQty(OrderDetailDTO orderDetailDTO) {
        ProductEntity product = productDao.findById(orderDetailDTO.getPro_id()).orElseThrow(() -> new ProductNotFound("Product not found"));
        System.out.println("Product found: " + product);

        int qty = Integer.parseInt(String.valueOf(orderDetailDTO.getQty()));
        System.out.println("Requested Quantity: " + qty);
        System.out.println("Current Quantity on Hand: " + product.getQuantity());

        if (product.getQuantity() < qty) {
            throw new ProductNotFound("Product quantity not enough");
        }

        // Update the quantity
        product.setQuantity(product.getQuantity() - qty);
        System.out.println("Updated Quantity on Hand: " + product.getQuantity());

        // Save the updated product
        try {
            productDao.save(product);
            System.out.println("Product saved successfully");
        } catch (Exception e) {
            System.err.println("Error saving product: " + e.getMessage());
            e.printStackTrace();
            return false;
        }

        return true;
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
