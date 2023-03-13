package com.bitskraft.bankaccountmock.controller;

import com.bitskraft.bankaccountmock.dto.CustomerDto;
import com.bitskraft.bankaccountmock.service.CustomerServices;
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
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;
    @Autowired
    private ModelMapper modelMapper;


    //Add Customer
    @PostMapping("addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody @Valid  CustomerDto customerDto) {

    return ResponseEntity.ok(this.customerServices.addCustomerDetail(customerDto));


    }
    //finding single customer
    @GetMapping("findCustomer/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable String customerId) {

        return ResponseEntity.ok(customerServices.getCustomer(customerId));


    }
    //Updating customer details
    @PutMapping("updateCustomer/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable String customerId,@RequestBody @Valid CustomerDto customerDto) {

        return ResponseEntity.ok(customerServices.updateCustomer(customerId, customerDto));

    }
    //delete single customer
    @DeleteMapping("deleteCustomer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String customerId) {

        return  ResponseEntity.ok(customerServices.deleteCustomerCustomerAccount(customerId));

    }
    //Find All Customer
    @GetMapping("findAllCustomer")
    public ResponseEntity<List<CustomerDto>> getAll() {
        return customerServices.getAllCustomer();

    }


}
