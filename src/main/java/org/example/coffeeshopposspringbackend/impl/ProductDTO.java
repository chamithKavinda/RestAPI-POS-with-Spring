package org.example.coffeeshopposspringbackend.impl;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshopposspringbackend.dto.SuperDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO implements SuperDTO {
    private String pro_id;
    private String category;
    private String price;
    private String pro_img;
    private String pro_name;
    private String quantity;
}
