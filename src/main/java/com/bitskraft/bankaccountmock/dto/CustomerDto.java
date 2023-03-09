package com.bitskraft.bankaccountmock.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDto {
    //For Customer
    private String customerId;
    private String name;
    private Date dob;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private String nationality;
    private String fatherName;
    private String motherName;
    private String grandFatherName;
    private String citizenshipNumber;
    private String passportNumber;
    private String imageName;
    private String cifId;
    private String branch;
    private String branchCode;

    //For Customer Account
    private String customerAccountId;
    private Date accountOpenDate;
    private String accountType;


}
