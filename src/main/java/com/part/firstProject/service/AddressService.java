package com.part.firstProject.service;

import com.part.firstProject.dto.AddressDTO;
import com.part.firstProject.entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> findAll();

    public AddressDTO findById(int id);

    public void save(AddressDTO addressList);

    public void deleteById(int id);
}
