package org.example.coffeeshopposspringbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshopposspringbackend.customeobj.CustomerResponse;
import org.example.coffeeshopposspringbackend.dto.SuperDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO , CustomerResponse {
    @NotBlank(message = "Customer Contact cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Customer Contact must be a 10-digit number")
    private String custContact;
    @NotBlank(message = "Customer Address cannot be empty")
    private String custAddress;
    @Pattern(regexp = "^C\\d{3}$", message = "Customer Id must be in the format C001")
    private String custId;
    @NotBlank(message = "Customer Name cannot be empty")
    private String custName;
}
