package com.bitskraft.bankaccountmock.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table
public class Customer {
    @Id
    @Column(nullable = false)
    private UUID customerId = UUID.randomUUID();

    @Column(nullable = false)
    private String name;
   /* @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String fatherName;
    @Column(nullable = false)
    private String motherName;
    @Column(nullable = false)
    private String grandFatherName;
    @Column(nullable = false)
    private String citizenshipNumber;
    private String passportNumber;
    @Column(nullable = false)
    private String imageName;
    @Column(nullable = false)
    private String cifId;
    @Column(nullable = false)
    private String branch;
    @Column(nullable = false)

    */
        @OneToMany(targetEntity=CustomerAccount.class ,  cascade = CascadeType.ALL)
    @JoinColumn(name="customerId",referencedColumnName="customerId")
   // @JsonIgnoreProperties("customer")
    // private List<Department> department = new ArrayList<>();
    private CustomerAccount customerAccount;


}

