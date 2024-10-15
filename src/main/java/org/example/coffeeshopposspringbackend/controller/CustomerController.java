package org.example.coffeeshopposspringbackend.controller;

import lombok.RequiredArgsConstructor;

import org.example.coffeeshopposspringbackend.customeobj.CustomerResponse;
import org.example.coffeeshopposspringbackend.exception.CustomerNotFound;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.dto.CustomerDTO;
import org.example.coffeeshopposspringbackend.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDTO customer) {
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                customerService.saveCustomer(customer);
                logger.info("Customer saved :"+ customer);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                logger.error(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{custContact}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCustomer(@PathVariable ("custContact") String custContact, @RequestBody CustomerDTO customer) {
        try {
            if (customer == null || custContact == null || custContact.isEmpty()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.updateCustomer(custContact, customer);
            logger.info("Customer updated : " + customer);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFound e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{custContact}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable ("custContact") String custContact) {
        try {
            customerService.deleteCustomer(custContact);
            logger.info("Customer deleted : " + custContact);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{custContact}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse getSelectedCustomer(@PathVariable ("custContact") String custContact){
        return customerService.getSelectedCustomer(custContact);
    }
}
