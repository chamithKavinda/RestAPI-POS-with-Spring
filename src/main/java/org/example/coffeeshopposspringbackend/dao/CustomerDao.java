package org.example.coffeeshopposspringbackend.dao;

import org.example.coffeeshopposspringbackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity, String> {
    Optional<CustomerEntity> findByCustContact(String custContact);
    boolean existsByCustContact(String custContact);
    CustomerEntity getReferenceByCustContact(String custContact);
}
