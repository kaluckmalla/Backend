package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.entity.Address;
import com.bitskraft.bankaccountmock.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    public List<Address> findAll();
    public Optional<Address> findById(int id);
    public void save(AddressDTO addressList);
}
