package com.bitskraft.bankaccountmock.dto;

import com.bitskraft.bankaccountmock.entity.Customer;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@ToString
public class CustomerAccountDto {
    private String customerAccountId;
    @NotNull
    @NotEmpty
    @NotBlank
    private String accountType;
    @NotNull @NotEmpty @NotBlank
    private String currency;
    @NotNull @NotEmpty @NotBlank
    private String currentBalance;
    private String accountNumber;
    //private boolean accountStatus;
    private String customerId;
    private Date accountOpenDate;
    private Date accountUpdatedDate;

    private Customer customer;

}
