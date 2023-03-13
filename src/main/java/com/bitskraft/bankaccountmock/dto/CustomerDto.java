package com.bitskraft.bankaccountmock.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class CustomerDto {
    //For Customer
    private String customerId;
    @NotNull @NotEmpty @NotBlank
    private String name;
@NotNull
@Past
    private Date dob;
    @NotNull @NotEmpty @NotBlank
    private String gender;
    @NotNull @NotEmpty @NotBlank
    @Pattern(regexp = "(\\+977 )[0-9]{10}",message="invalid phone number !!")

    private String phone;
    @NotNull @NotEmpty @NotBlank
    //@Email
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",message="invalid email address !!")
    private String email;
    @NotNull @NotEmpty @NotBlank
    private String address;
    @NotNull @NotEmpty @NotBlank
    private String nationality;
    @NotNull @NotEmpty @NotBlank
    private String fatherName;
    @NotNull @NotEmpty @NotBlank
    private String motherName;
    @NotNull @NotEmpty @NotBlank
    private String grandFatherName;
    @NotNull @NotEmpty @NotBlank
    private String citizenshipNumber;
    private String passportNumber;
    @NotNull @NotEmpty @NotBlank
    private String imageName;
    private String cifId;
    @NotNull @NotEmpty @NotBlank
    private String branch;
    @NotNull @NotEmpty @NotBlank
    private String branchCode;
    private Date customerAddedDate;

    private Date customerUpdatedDate;


}
