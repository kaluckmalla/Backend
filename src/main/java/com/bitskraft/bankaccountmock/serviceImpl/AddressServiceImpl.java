package com.bitskraft.bankaccountmock.serviceImpl;

import com.bitskraft.bankaccountmock.dto.AddressDTO;
import com.bitskraft.bankaccountmock.entity.Address;
import com.bitskraft.bankaccountmock.repository.AddressRepository;
import com.bitskraft.bankaccountmock.service.AddressService;
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
    public void save(Address addressList) {
       addressRepository.save(addressList);
    }

}
