package org.example.coffeeshopposspringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO {
    private String orderId;
    private String custContact;
    private LocalDateTime orderDateTime;
    private List<OrderDetailDTO> orderDetails;
}
