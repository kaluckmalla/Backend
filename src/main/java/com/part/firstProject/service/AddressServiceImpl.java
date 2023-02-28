package com.part.firstProject.service;

import com.part.firstProject.dto.AddressDTO;
import com.part.firstProject.entity.Address;
import com.part.firstProject.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    AddressRepository addressRepository;
    @Autowired
    public  AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }
    @Override
    public List<Address> findAll() {
          return  addressRepository.findAll();
    }

    @Override
    public AddressDTO findById(int id) {
        return null;
    }

    @Override
    public void save(AddressDTO addressList) {
          Address address=new Address();

    }

    @Override
    public void deleteById(int id) {

    }
}
