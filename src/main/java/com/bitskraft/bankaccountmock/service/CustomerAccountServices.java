package com.bitskraft.bankaccountmock.service;


import com.bitskraft.bankaccountmock.dto.CustomerAccountDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerAccountServices {
    String addCustomerAccount(CustomerAccountDto customerAccountDto);

    ResponseEntity<List<CustomerAccountDto>> getCustomerAccount(String customerId);

    String deleteCustomerAccount(String customerId);

    ResponseEntity<List<CustomerAccountDto>> getAllCustomerAccounts();

    String updateCustomerAccount(String customerId,String customerAccountId, CustomerAccountDto customerAccountDto);
}
