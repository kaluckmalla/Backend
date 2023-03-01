package com.bitskraft.bankaccountmock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "States")
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="state_id")
    private int id;
    @Column(name="state_name")
    private String name;

    @ManyToOne
    private Country country;
}