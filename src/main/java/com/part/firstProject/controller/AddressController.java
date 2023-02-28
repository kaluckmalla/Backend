package com.part.firstProject.controller;

import com.part.firstProject.dto.AddressDTO;
import com.part.firstProject.entity.Address;
import com.part.firstProject.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {
    private AddressService addressService;
    @Autowired
    public AddressController(AddressService theaddressService){
        addressService=theaddressService;
    }
    @GetMapping("/address")
    public ResponseEntity<?> findAll(){
        List<Address> address= addressService.findAll();
        return new ResponseEntity<>(address,address.size()>0?HttpStatus.OK: HttpStatus.NOT_FOUND);
    }
}
