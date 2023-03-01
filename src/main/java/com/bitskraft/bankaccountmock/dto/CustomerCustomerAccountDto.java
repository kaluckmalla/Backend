package com.bitskraft.bankaccountmock.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CustomerCustomerAccountDto {

    private UUID customerId = UUID.randomUUID();

    private String name;

    private UUID  customerAccountId =UUID.randomUUID();
    private String accountType;
}
