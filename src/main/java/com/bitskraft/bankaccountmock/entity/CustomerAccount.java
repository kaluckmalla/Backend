package com.bitskraft.bankaccountmock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
public class CustomerAccount {
    @Id
    @Column(nullable = false)
    private UUID customerAccountId = UUID.randomUUID();
    @Column(nullable = false)
    private String accountType;
    /*@Column(nullable = false)
    private String currency;
    @Column(nullable = false)
    private String currentBalance;
    @Column(nullable = false)
    private String accountNumber;
    @Column(nullable = false)
    private boolean accountStatus;

*/
}
