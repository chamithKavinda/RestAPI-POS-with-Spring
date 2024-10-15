package org.example.coffeeshopposspringbackend.customeobj.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshopposspringbackend.customeobj.CustomerResponse;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerErrorResponse implements CustomerResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
