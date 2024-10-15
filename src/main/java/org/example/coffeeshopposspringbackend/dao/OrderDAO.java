package org.example.coffeeshopposspringbackend.dao;

import org.example.coffeeshopposspringbackend.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<OrderEntity, String> {
}
