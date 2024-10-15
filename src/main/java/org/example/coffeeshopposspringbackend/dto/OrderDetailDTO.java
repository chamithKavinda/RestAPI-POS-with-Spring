package org.example.coffeeshopposspringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO implements SuperDTO{
    private String orderId;
    private String pro_id;
    private int qty;
    private double unitPrice;
}
