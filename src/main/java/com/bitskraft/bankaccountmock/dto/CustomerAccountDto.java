package com.bitskraft.bankaccountmock.dto;

import com.bitskraft.bankaccountmock.entity.Customer;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@ToString
public class CustomerAccountDto {
    private String customerAccountId;
    private Date accountOpenDate;
    private String accountType;
    private String currency;
    private String currentBalance;
    private String accountNumber;
    //private boolean accountStatus;
    private String customerId;

    private Customer customer;

}
