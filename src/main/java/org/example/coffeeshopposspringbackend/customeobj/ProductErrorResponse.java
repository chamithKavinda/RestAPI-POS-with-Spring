package org.example.coffeeshopposspringbackend.customeobj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductErrorResponse implements ProductResponse, Serializable{
    private int errorCode;
    private String errorMessage;
}
