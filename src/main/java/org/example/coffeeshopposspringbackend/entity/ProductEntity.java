package org.example.coffeeshopposspringbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product")
@Entity
public class ProductEntity implements SuperEntity {
    @Id
    private String pro_id;
    private String pro_name;
    private String price;
    private String category;
    private int quantity;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> orderDetails;
}
