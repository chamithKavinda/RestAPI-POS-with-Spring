package org.example.coffeeshopposspringbackend.dao;

import org.example.coffeeshopposspringbackend.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, String> {
}
