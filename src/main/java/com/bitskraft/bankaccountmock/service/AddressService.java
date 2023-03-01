package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.entity.Address;
import com.bitskraft.bankaccountmock.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    public List<Address> findAll();

    public AddressDTO findById(int id);

    public void save(Address addressList);

}
