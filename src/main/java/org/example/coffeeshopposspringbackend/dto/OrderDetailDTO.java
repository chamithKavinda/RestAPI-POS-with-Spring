package org.example.coffeeshopposspringbackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshopposspringbackend.customeobj.OrderResponse;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO implements SuperDTO , OrderResponse {
    private String orderId;
    @NotBlank(message = "Product id cannot be blank")
    private String pro_id;
    @Min(value = 1, message = "Quantity must be at least 1")
    private int qty;
    @Positive(message = "Unit price must be greater than zero")
    private double unitPrice;
}
