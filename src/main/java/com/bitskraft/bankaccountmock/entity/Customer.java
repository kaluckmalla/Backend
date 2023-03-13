package com.bitskraft.bankaccountmock.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
public class Customer {
    @Id
    private String customerId;
    private String name;
    @Column(name="dateOfBirth",nullable = false)
    private Date dob;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false,unique = true)
    private String phone;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String nationality;
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
    private String branchCode;

    @Column(nullable = false)
    private Date customerAddedDate;
    private Date customerUpdatedDate;
    /*
        @OneToMany(targetEntity=CustomerAccount.class ,  cascade = CascadeType.ALL)
    @JoinColumn(name="customerId",referencedColumnName="customerId")
   // @JsonIgnoreProperties("customer")
    // private List<Department> department = new ArrayList<>();
    private CustomerAccount customerAccount;

*/
}

