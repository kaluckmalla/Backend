package com.bitskraft.bankaccountmock.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table
public class CustomerAccount {
    @Id
    private String customerAccountId;
    @Column(nullable = false)
    private Date accountOpenDate;
    @Column(nullable = false)
    private String accountType;
    @Column(nullable = false)
    private String currency;
    @Column(nullable = false)
    private String currentBalance;
    @Column(nullable = false)
    private String accountNumber;
//    @Column(nullable = false)
//    private boolean accountStatus;

   @ManyToOne(targetEntity=Customer.class ,  cascade = CascadeType.ALL)
   @JoinColumn(name="customerId")//, referencedColumnName="customerId",nullable=false)
private Customer customer;
}
