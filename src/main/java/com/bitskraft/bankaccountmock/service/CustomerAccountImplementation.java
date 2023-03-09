package com.bitskraft.bankaccountmock.service;


import com.bitskraft.bankaccountmock.dto.CustomerAccountDto;
import com.bitskraft.bankaccountmock.dto.CustomerDto;
import com.bitskraft.bankaccountmock.entity.Customer;
import com.bitskraft.bankaccountmock.entity.CustomerAccount;
import com.bitskraft.bankaccountmock.repository.CustomerAccountRepository;
import com.bitskraft.bankaccountmock.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerAccountImplementation implements CustomerAccountServices {
    @Autowired
    private CustomerAccountRepository customerAccountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String addCustomerAccount(CustomerAccountDto customerAccountDto) {

// convert DTO to entity
        Optional<Customer> customer = customerRepository.findById(customerAccountDto.getCustomerId());
        if (customer.isEmpty()) {
            throw new RuntimeException("Customer not exist");
        }
        else {



            List<CustomerAccount> customerAccount = customerAccountRepository.findByCustomerId(customer.get().getCustomerId());
            if (customerAccount.isEmpty()) {
                //Convert Dto to Entity
                CustomerAccount request = this.convertDtoToEntity(customerAccountDto, customer.get());
                customerAccountRepository.save(request);
                return request.getAccountType() + " account added successfully";
            } else {

//checking account number
                //checking account type


System.out.println("wwwwwwwwww................"+customerAccount.contains(customerAccountDto.getAccountType()));




                //Convert Dto to Entity
              //  CustomerAccount request = this.convertDtoToEntity(customerAccountDto, customer.get());
                //customerAccountRepository.save(request);
               // return request.getAccountType() + " account added successfully";
                return  null;
            }
        }
    }




    @Override
    public ResponseEntity<List<CustomerAccountDto>> getCustomerAccount(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new RuntimeException("Customer not exist");
        }else {

//Directly convert to Customer Account to Customer Account Dto
            List<CustomerAccountDto> response = customerAccountRepository.findByCustomerId(customerId).stream().map(this::convertEntityToDto).collect(Collectors.toList());

        if (response.isEmpty()) {
            throw new RuntimeException("You have not created any account yet");
        } else {
            return ResponseEntity.ok(response);
        }
    }
    }

    @Override
    public String deleteCustomerAccount(String customerAccountId) {
        Optional<CustomerAccount> customerAccount=customerAccountRepository.findById(customerAccountId);
        if (customerAccount.isEmpty())
        {
            return "Customer account id "+customerAccountId+" not found";
        }
        else{
            customerAccountRepository.delete(customerAccount.get());
            return "Customer account deleted successfully";

        }
    }

    private CustomerAccount convertDtoToEntity(CustomerAccountDto customerAccountDto, Customer customer) {
        CustomerAccount customerAccount = new CustomerAccount();


        customerAccount.setCustomerAccountId(UUID.randomUUID().toString());
        customerAccount.setAccountOpenDate(customerAccountDto.getAccountOpenDate());
        customerAccount.setAccountType(customerAccountDto.getAccountType());
        customerAccount.setCurrency(customerAccountDto.getCurrency());
        customerAccount.setCurrentBalance(customerAccountDto.getCurrentBalance());
        customerAccount.setAccountNumber(customerAccountDto.getAccountNumber());
        customerAccount.setCustomer(customer);

        return customerAccount;

    }
    private CustomerAccountDto convertEntityToDto(CustomerAccount customerAccount){
        CustomerAccountDto customerAccountDto=new CustomerAccountDto();

        customerAccountDto.setCustomerAccountId(customerAccount.getCustomerAccountId());
       customerAccountDto.setAccountOpenDate(customerAccount.getAccountOpenDate());
       customerAccountDto.setAccountType(customerAccount.getAccountType());
       customerAccountDto.setCurrency(customerAccount.getCurrency());
       customerAccountDto.setCurrentBalance(customerAccount.getCurrentBalance());
       customerAccountDto.setAccountNumber(customerAccount.getAccountNumber());
       customerAccountDto.setCustomerId(customerAccount.getCustomer().getCustomerId());
       customerAccountDto.setCustomer(customerAccount.getCustomer());
        return  customerAccountDto;
    }
}
