package org.example.coffeeshopposspringbackend.customeobj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductErrorResponse implements ProductResponse{
    private int errorCode;
    private String errorMessage;
}
