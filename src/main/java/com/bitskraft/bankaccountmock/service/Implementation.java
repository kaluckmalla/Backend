package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankingproject.dto.CustomerCustomerAccountDto;
import com.bitskraft.bankingproject.entities.Customer;
import com.bitskraft.bankingproject.repository.CustomerAccountRepo;
import com.bitskraft.bankingproject.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Implementation implements Services{
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CustomerAccountRepo customerAccountRepo;
    @Override
    public ResponseEntity<Customer> addCustomerDetail(Customer request) {
        return ResponseEntity.ok().body(customerRepo.save(request));
    }
    private CustomerCustomerAccountDto convertEntityToDto(Customer customer){
        CustomerCustomerAccountDto customerCustomerAccountDto=new CustomerCustomerAccountDto();
        customerCustomerAccountDto.setCustomerId(customer.getCustomerId());
        customerCustomerAccountDto.setName(customer.getName());

       // customerCustomerAccountDto.setCustomerAccountId(customer.getCustomerAccount().);
        return  null;
    }
}
