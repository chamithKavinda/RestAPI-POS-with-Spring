package org.example.coffeeshopposspringbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
@Entity
public class OrderEntity implements SuperEntity{
    @Id
    private String orderId;
    @ManyToOne
    @JoinColumn(name = "custContact", referencedColumnName = "custContact")
    private CustomerEntity customer;
    private LocalDateTime orderDateTime;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetailsEntity> orderDetails;
}
