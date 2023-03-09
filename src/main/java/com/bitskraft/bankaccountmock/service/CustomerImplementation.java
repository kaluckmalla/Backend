package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.customerexception.CustomerDateOfBirthNotValid;
import com.bitskraft.bankaccountmock.customerexception.CustomerEmailAlreadyExist;
import com.bitskraft.bankaccountmock.customerexception.CustomerNotFound;
import com.bitskraft.bankaccountmock.customerexception.CustomerPhoneAlreadyExist;
import com.bitskraft.bankaccountmock.dto.CustomerDto;
import com.bitskraft.bankaccountmock.entity.Customer;
import com.bitskraft.bankaccountmock.entity.CustomerAccount;
import com.bitskraft.bankaccountmock.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerImplementation implements CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;


    //Add customer
    @Override
    public String addCustomerDetail(CustomerDto customerDto){

            Date Currentdate = new Date();

            boolean phoneExist = customerRepository.existsByPhone(customerDto.getPhone());
            boolean emailExist = customerRepository.existsByEmail(customerDto.getEmail());

            if (phoneExist) {
                throw new CustomerPhoneAlreadyExist("Phone number already exist");
                // return new ResponseEntity("Phone number already exist", HttpStatus.BAD_REQUEST);
            } else if (emailExist) {
                throw new CustomerEmailAlreadyExist("Email already exist");

                // return new ResponseEntity("Email already exist", HttpStatus.BAD_REQUEST);

            } else if (customerDto.getDob().after(Currentdate)) {
                throw new CustomerDateOfBirthNotValid("Date of birth not valid");
                // return new ResponseEntity("Date of birth not valid", HttpStatus.BAD_REQUEST);

            } else {
                // convert DTO to entity
                Customer request = this.convertDtoToEntity(customerDto);
                customerRepository.save(request);
                return "Customer added successfully";
            }

    }

    //Getting single customer details
    @Override
    public CustomerDto getCustomerCustomerAccount(String customerId) {
        Optional<Customer> request = customerRepository.findById(customerId);
        if(request.isEmpty()) {
            throw new CustomerNotFound("Customer not found");


        }else {
            CustomerDto response=this.convertEntityToDto(request.get());
            return response;
        }
    }
    //update customer
    @Override
    public String updateCustomerCustomerAccount(String customerId, CustomerDto customerDto) {
        Optional<Customer> request=customerRepository.findById(customerId);
        if (request.isEmpty()){
            throw new CustomerNotFound("Customer not found");

        }
        else {
            Customer newCustomer=this.convertDtoToEntity(customerDto);

            request.get().setName(newCustomer.getName());
            request.get().setDob(newCustomer.getDob());
            request.get().setGender(newCustomer.getGender());
            request.get().setPhone(newCustomer.getPhone());
            request.get().setEmail(newCustomer.getEmail());
            request.get().setAddress(newCustomer.getAddress());
            request.get().setNationality(newCustomer.getNationality());
            request.get().setFatherName(newCustomer.getFatherName());
            request.get().setMotherName(newCustomer.getMotherName());
            request.get().setGrandFatherName(newCustomer.getGrandFatherName());
            request.get().setCitizenshipNumber(newCustomer.getCitizenshipNumber());
            request.get().setPassportNumber(newCustomer.getPassportNumber());
            request.get().setImageName(newCustomer.getImageName());
            request.get().setCifId(newCustomer.getCifId());
            request.get().setBranch(newCustomer.getBranch());
            request.get().setBranchCode(newCustomer.getBranchCode());

            customerRepository.save(request.get());
            return "Customer updated successfully";
        }        }

    //delete customer
    @Override
    public String deleteCustomerCustomerAccount(String customerId) {

        Optional<Customer> request = customerRepository.findById(customerId);
        if(request.isEmpty()) {
            throw new CustomerNotFound("Customer not found");

        }else {
            customerRepository.delete(request.get());
            return "Customer deleted successfully";
        }
    }
    //finding all customer list
    @Override
    public ResponseEntity<List<CustomerDto>> getAllCustomerCustomerAccount() {
        // convert all list entity to DTO
        List<CustomerDto> response = customerRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
        return ResponseEntity.ok(response);

    }


    private Customer convertDtoToEntity(CustomerDto customerDto){
       Customer customer=new Customer();


        customer.setCustomerId(UUID.randomUUID().toString());
        customer.setName(customerDto.getName());
        customer.setDob(customerDto.getDob());
        customer.setGender(customerDto.getGender());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        customer.setNationality(customerDto.getNationality());
        customer.setFatherName(customerDto.getFatherName());
        customer.setMotherName(customerDto.getMotherName());
        customer.setGrandFatherName(customerDto.getGrandFatherName());
        customer.setCitizenshipNumber(customerDto.getCitizenshipNumber());
        customer.setPassportNumber(customerDto.getPassportNumber());
        customer.setImageName(customerDto.getImageName());
        customer.setCifId(customerDto.getCifId());
        customer.setBranch(customerDto.getBranch());
        customer.setBranchCode(customerDto.getBranchCode());

        return  customer;

    }
    private CustomerDto convertEntityToDto(Customer customer){
        CustomerDto customerDto=new CustomerDto();

        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setName(customer.getName());
        customerDto.setDob(customer.getDob());
        customerDto.setGender(customer.getGender());
        customerDto.setPhone(customer.getPhone());
        customerDto.setEmail(customer.getEmail());
        customerDto.setAddress(customer.getAddress());
        customerDto.setNationality(customer.getNationality());
        customerDto.setFatherName(customer.getFatherName());
        customerDto.setMotherName(customer.getMotherName());
        customerDto.setGrandFatherName(customer.getGrandFatherName());
        customerDto.setCitizenshipNumber(customer.getCitizenshipNumber());
        customerDto.setPassportNumber(customer.getPassportNumber());
        customerDto.setImageName(customer.getImageName());
        customerDto.setCifId(customer.getCifId());
        customerDto.setBranch(customer.getBranch());
        customerDto.setBranchCode(customer.getBranchCode());

        return  customerDto;
    }
}
