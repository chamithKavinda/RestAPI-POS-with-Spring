package org.example.coffeeshopposspringbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customer")
@Entity
public class CustomerEntity implements SuperEntity{
    @Id
    private String custContact;
    private String custAddress;
    private String custId;
    private String custName;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<OrderEntity> order;
}
