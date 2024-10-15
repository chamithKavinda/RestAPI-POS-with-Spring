package org.example.coffeeshopposspringbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.coffeeshopposspringbackend.dto.OrderDTO;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private final OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDTO order) {
        System.out.println("1");
        if (order == null) {
            System.out.println("2");
            return ResponseEntity.badRequest().build();
        } else {
            try {
                System.out.println("3");
                orderService.saveOrder(order);
                System.out.println("4");
                return ResponseEntity.created(null).build();
            } catch (DataPersistFailedException e) {
                System.out.println("5");
                return ResponseEntity.badRequest().build();
            } catch (Exception e) {
                System.out.println("6");
                return ResponseEntity.internalServerError().build();
            }
        }
    }
}
