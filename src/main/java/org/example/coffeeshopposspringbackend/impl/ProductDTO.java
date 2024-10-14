package org.example.coffeeshopposspringbackend.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshopposspringbackend.customeobj.ProductResponse;
import org.example.coffeeshopposspringbackend.dto.SuperDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO implements SuperDTO , ProductResponse {
    private String pro_id;
    private String pro_name;
    private String price;
    private String category;
    private String quantity;
}
