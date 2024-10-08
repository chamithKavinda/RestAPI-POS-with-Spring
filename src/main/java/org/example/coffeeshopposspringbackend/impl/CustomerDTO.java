package org.example.coffeeshopposspringbackend.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshopposspringbackend.customeobj.CustomerResponse;
import org.example.coffeeshopposspringbackend.dto.SuperDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO , CustomerResponse {
    private String custContact;
    private String custAddress;
    private String custId;
    private String custName;
}
