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
@Table(name="Address")
public class Address {
    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Country country;
    @ManyToOne(cascade = {CascadeType.ALL})
    private  States states;
    @ManyToOne(cascade = {CascadeType.ALL})
    private District districts;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Municipality municipalities;
}
