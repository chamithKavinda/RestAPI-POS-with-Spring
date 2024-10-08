package org.example.coffeeshopposspringbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class ProductEntity implements SuperEntity {
    @Id
    private String pro_id;
    private String pro_name;
    @Column(columnDefinition = "LONGTEXT")
    private String pro_img;
    private String price;
    private String category;
    private String quantity;
}
