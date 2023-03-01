package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankingproject.entities.Customer;
import org.springframework.http.ResponseEntity;

public interface Services {
    ResponseEntity<Customer> addCustomerDetail(Customer request);
}
