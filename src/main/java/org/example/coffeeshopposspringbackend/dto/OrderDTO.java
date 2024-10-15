package org.example.coffeeshopposspringbackend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshopposspringbackend.customeobj.OrderResponse;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO , OrderResponse {
    private String orderId;
    @NotBlank(message = "Customer Contact cannot be blank")
    private String custContact;
    private LocalDateTime orderDateTime;
    @NotEmpty(message = "Order must contain at least one order detail")
    @Valid
    private List<OrderDetailDTO> orderDetails;
}
