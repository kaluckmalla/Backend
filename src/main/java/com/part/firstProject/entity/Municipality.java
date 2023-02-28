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
@Table(name = "Municipality")
public class Municipality {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="municipality_id")
    private int id;
   @Column(name="municipality_name")
    private String name;
}
