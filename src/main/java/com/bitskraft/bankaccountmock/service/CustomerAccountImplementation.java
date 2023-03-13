package com.bitskraft.bankaccountmock.service;


import com.bitskraft.bankaccountmock.customerexception.AccountNotFound;
import com.bitskraft.bankaccountmock.customerexception.AccountTypeAlreadyExist;
import com.bitskraft.bankaccountmock.customerexception.CustomerNotFound;
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
        Optional<Customer> customer = customerRepository.findById(customerAccountDto.getCustomerId());
        if (customer.isEmpty()) {
            throw new CustomerNotFound("Customer not found");
        }
        else {
            List<CustomerAccount> customerAccount = customerAccountRepository.findByCustomerIdAccountType(customer.get().getCustomerId(),customerAccountDto.getAccountType());
            if (customerAccount.isEmpty()) {
                //Convert Dto to Entity
                CustomerAccount request = this.convertDtoToEntity(customerAccountDto, customer.get());
                customerAccountRepository.save(request);
                return request.getAccountType() + " account created successfully";
            } else {
                throw new AccountTypeAlreadyExist("Your "+customerAccountDto.getAccountType()+" account type already exist");
            }
        }
    }
    @Override
    public ResponseEntity<List<CustomerAccountDto>> getCustomerAccount(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new CustomerNotFound("Customer not found");
        }else {

//Directly convert to Customer Account to Customer Account Dto
            List<CustomerAccountDto> response = customerAccountRepository.findByCustomerId(customerId).stream().map(this::convertEntityToDto).collect(Collectors.toList());

        if (response.isEmpty()) {
            throw new AccountNotFound("You have not created any account yet");
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
            throw new AccountNotFound("Customer account not found");
        }
        else{
            customerAccountRepository.delete(customerAccount.get());
            return "Customer account deleted successfully";

        }
    }

    @Override
    public ResponseEntity<List<CustomerAccountDto>> getAllCustomerAccounts() {
        // convert all list entity to DTO
        List<CustomerAccountDto> response = customerAccountRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
        if (response.isEmpty()) {
            throw new AccountNotFound("You have not added any account yet");
        }else{
            return ResponseEntity.ok(response);

        }
    }

    @Override
    public String updateCustomerAccount(String customerId,String customerAccountId, CustomerAccountDto customerAccountDto) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new CustomerNotFound("Customer not found");
        }else {
//Directly convert to Customer Account to Customer Account Dto
            Optional<CustomerAccount> request =customerAccountRepository.findById(customerAccountId);

            if (request.isEmpty()) {
                throw new AccountNotFound("Your account not found");
            } else {
                Date currentDate=new Date();

                CustomerAccount newCustomerAccount=this.convertDtoToEntity(customerAccountDto,customer.get());

                request.get().setAccountType(newCustomerAccount.getAccountType());
                request.get().setCurrency(newCustomerAccount.getCurrency());
                request.get().setCurrentBalance(newCustomerAccount.getCurrentBalance());
                request.get().setAccountNumber(newCustomerAccount.getAccountNumber());
                request.get().setAccountOpenDate(request.get().getAccountOpenDate());
                request.get().setAccountUpdatedDate(currentDate);

                request.get().setCustomer(request.get().getCustomer());
                customerAccountRepository.save(request.get());
                return "Customer account updated successfully";
            }
        }
    }

    private CustomerAccount convertDtoToEntity(CustomerAccountDto customerAccountDto, Customer customer) {
        Date currentDate=new Date();
        CustomerAccount customerAccount = new CustomerAccount();

        customerAccount.setCustomerAccountId(UUID.randomUUID().toString());
        customerAccount.setAccountType(customerAccountDto.getAccountType());
        customerAccount.setCurrency(customerAccountDto.getCurrency());
        customerAccount.setCurrentBalance(customerAccountDto.getCurrentBalance());
        customerAccount.setAccountNumber(this.CustomerAccountNumber());
        customerAccount.setAccountOpenDate(currentDate);
        customerAccount.setAccountUpdatedDate(null);

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
    //generating sequence account number
    private static int accountNumberSequence = 0;

    private String CustomerAccountNumber(){
        int accountNumber = 0;
        accountNumber = ++accountNumberSequence;

        return Integer.toString(accountNumber);
    }
}
