package com.bitskraft.bankaccountmock.controller;

import com.bitskraft.bankaccountmock.dto.AddressDTO;
import com.bitskraft.bankaccountmock.entity.Address;
import com.bitskraft.bankaccountmock.exception.AddressException;
import com.bitskraft.bankaccountmock.service.AddressService;
import org.hibernate.exception.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/address")
    public ResponseEntity<?> findAll(){
        List<Address> address= addressService.findAll();
        return new ResponseEntity<>(address,address.size()>0?HttpStatus.OK: HttpStatus.NOT_FOUND);
    }
    @PostMapping("/address")
    public ResponseEntity<?> save(@RequestBody AddressDTO addressDTO) {
        try {
            addressService.save(addressDTO);
            return new ResponseEntity<AddressDTO>(addressDTO, HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
