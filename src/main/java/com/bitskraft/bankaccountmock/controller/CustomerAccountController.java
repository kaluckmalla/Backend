package com.bitskraft.bankaccountmock.controller;



import com.bitskraft.bankaccountmock.dto.CustomerAccountDto;
import com.bitskraft.bankaccountmock.dto.CustomerDto;
import com.bitskraft.bankaccountmock.service.CustomerAccountServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> addCustomerAccount(@RequestBody CustomerAccountDto customerAccountDto) {

        return ResponseEntity.ok(this.customerAccountServices.addCustomerAccount(customerAccountDto));
    }//finding single customer account information by customer id(referenced id)
    @GetMapping("findCustomerAccount/{customerId}")
    public ResponseEntity<List<CustomerAccountDto>> getCustomerAccount(@PathVariable String customerId) {

        return customerAccountServices.getCustomerAccount(customerId);


    }
    //Deleting customer account by using customer id and customer account id
    @DeleteMapping("deleteCustomerAccount/{customerAccountId}")
    public ResponseEntity<String> deleteCustomerAccount(@PathVariable String customerAccountId) {

        return ResponseEntity.ok(customerAccountServices.deleteCustomerAccount(customerAccountId));


    }
    /*
    //finding single customer
    @GetMapping("findCustomer/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable String customerId) {

        return ResponseEntity.ok(customerServices.getCustomerCustomerAccount(customerId));


    }
    //Updating customer details
    @PutMapping("updateCustomer/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable String customerId,@RequestBody CustomerDto customerDto) {

        return ResponseEntity.ok(customerServices.updateCustomerCustomerAccount(customerId, customerDto));

    }
    //delete single customer
    @DeleteMapping("deleteCustomer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String customerId) {

        return  ResponseEntity.ok(customerServices.deleteCustomerCustomerAccount(customerId));

    }
    //Find All Customer
    @GetMapping("findAllCustomer")
    public ResponseEntity<List<CustomerDto>> getAll() {
        return customerServices.getAllCustomerCustomerAccount();

    }
*/


}
