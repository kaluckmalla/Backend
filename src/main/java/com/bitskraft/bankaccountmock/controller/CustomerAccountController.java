package com.bitskraft.bankaccountmock.controller;



import com.bitskraft.bankaccountmock.dto.CustomerAccountDto;
import com.bitskraft.bankaccountmock.dto.CustomerDto;
import com.bitskraft.bankaccountmock.service.CustomerAccountServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/")
public class CustomerAccountController {
    @Autowired
    private CustomerAccountServices customerAccountServices;
    @Autowired
    private ModelMapper modelMapper;

    //Add Customer
    @PostMapping("addCustomerAccount")
    public ResponseEntity<String> addCustomerAccount(@RequestBody @Valid CustomerAccountDto customerAccountDto) {
        return ResponseEntity.ok(this.customerAccountServices.addCustomerAccount(customerAccountDto));
    }

    //finding single customer account information by customer id(referenced id)
    @GetMapping("findCustomerAccount/{customerId}")
    public ResponseEntity<List<CustomerAccountDto>> getCustomerAccount(@PathVariable String customerId) {
        return customerAccountServices.getCustomerAccount(customerId);
    }

    //Update Account
@PutMapping("updateCustomerAccount/{customerId}/{customerAccountId}")
public ResponseEntity<String> updateCustomerAccount(@PathVariable String customerId,@PathVariable String customerAccountId,@RequestBody @Valid CustomerAccountDto customerAccountDto)
{
return ResponseEntity.ok(customerAccountServices.updateCustomerAccount(customerId,customerAccountId,customerAccountDto));
}
    //Deleting customer account by using customer id and customer account id
    @DeleteMapping("deleteCustomerAccount/{customerAccountId}")
    public ResponseEntity<String> deleteCustomerAccount(@PathVariable String customerAccountId) {
        return ResponseEntity.ok(customerAccountServices.deleteCustomerAccount(customerAccountId));
    }

    //finding all customer accounts

    @GetMapping("findAllCustomerAccount")
    public ResponseEntity<List<CustomerAccountDto>> getAllAccounts() {
        return customerAccountServices.getAllCustomerAccounts();

    }
}
