package org.example.coffeeshopposspringbackend.service.impl;

import org.example.coffeeshopposspringbackend.customeobj.impl.CustomerErrorResponse;
import org.example.coffeeshopposspringbackend.customeobj.CustomerResponse;
import org.example.coffeeshopposspringbackend.dao.CustomerDao;
import org.example.coffeeshopposspringbackend.entity.CustomerEntity;
import org.example.coffeeshopposspringbackend.exception.CustomerNotFound;
import org.example.coffeeshopposspringbackend.exception.DataPersistFailedException;
import org.example.coffeeshopposspringbackend.dto.CustomerDTO;
import org.example.coffeeshopposspringbackend.service.CustomerService;
import org.example.coffeeshopposspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        var customerEntity = mapping.convertToEntity(customerDTO);
        var savedCustomer = customerDao.save(customerEntity);
        if(savedCustomer == null){
            throw new DataPersistFailedException("Cannot save customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.convertToCustomerDTO(customerDao.findAll());
    }

    @Override
    public void updateCustomer(String custContact, CustomerDTO incomeCustomerDTO) {
        Optional<CustomerEntity> tmpcustomerEntity = customerDao.findByCustContact(custContact);

        if (!tmpcustomerEntity.isPresent()){
            throw new CustomerNotFound("Customer Not Found");
        }else {
            tmpcustomerEntity.get().setCustAddress(incomeCustomerDTO.getCustAddress());
            tmpcustomerEntity.get().setCustId(incomeCustomerDTO.getCustId());
            tmpcustomerEntity.get().setCustName(incomeCustomerDTO.getCustName());

            customerDao.save(tmpcustomerEntity.get());
        }
    }

    @Override
    public void deleteCustomer(String custContact) {
        Optional<CustomerEntity> findId = customerDao.findById(custContact);
        if(!findId.isPresent()){
            throw new CustomerNotFound("Customer not found");
        }else {
            customerDao.deleteById(custContact);
        }
    }

    @Override
    public CustomerResponse getSelectedCustomer(String custContact) {
        if(customerDao.existsByCustContact(custContact)){
            return mapping.convertToDTO(customerDao.getReferenceByCustContact(custContact));
        }else {
            return new CustomerErrorResponse(0,"Customer not found");
        }
    }
}
