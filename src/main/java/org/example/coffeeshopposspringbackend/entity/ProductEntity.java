package org.example.coffeeshopposspringbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String quantity;
}
