package org.example.coffeeshopposspringbackend.customeobj.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshopposspringbackend.customeobj.ProductResponse;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductErrorResponse implements ProductResponse, Serializable{
    private int errorCode;
    private String errorMessage;
}
