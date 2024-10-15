package org.example.coffeeshopposspringbackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshopposspringbackend.customeobj.ProductResponse;
import org.example.coffeeshopposspringbackend.dto.SuperDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO implements SuperDTO , ProductResponse {
    @NotBlank(message = "Product Id cannot be empty")
    @Pattern(regexp = "^P\\d{3}$", message = "Product Id must be in the format P001")
    private String pro_id;
    @NotBlank(message = "Product Name cannot be empty")
    private String pro_name;
    @Positive(message = "Price must be greater than zero")
    private String price;
    @NotBlank(message = "Category cannot be blank")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Category must contain only letters")
    private String category;
    @Min(value = 1, message = "Quantity cannot be negative")
    private String quantity;
}
