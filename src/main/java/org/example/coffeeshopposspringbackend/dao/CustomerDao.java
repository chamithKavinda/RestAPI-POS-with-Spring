package org.example.coffeeshopposspringbackend.dao;

import org.example.coffeeshopposspringbackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity, String> {
}
