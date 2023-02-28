package com.part.firstProject.entity;

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
@Table(name="District")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "district_id")
    private int id;

    @Column(name="district_name")
    private String name;

    @OneToMany
    private Municipality municipalities;
}
