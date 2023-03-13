package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CustomerServices {

    String addCustomerDetail(CustomerDto customerDto);

     CustomerDto getCustomer(String customerId);
    String updateCustomer(String customerId, CustomerDto customerDto);

    String deleteCustomerCustomerAccount(String customerId);

    ResponseEntity<List<CustomerDto>> getAllCustomer();

}
