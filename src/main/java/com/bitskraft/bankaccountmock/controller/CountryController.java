package com.bitskraft.bankaccountmock.controller;

import com.bitskraft.bankaccountmock.entity.Country;
import com.bitskraft.bankaccountmock.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {
    @Autowired
      CountryService countryService;

 @GetMapping("/getCountry")
 public ResponseEntity<?> findAll(){
 List<Country> countries=countryService.findAll();
     return new ResponseEntity<>(countries,countries.size()>0? HttpStatus.OK:HttpStatus.NOT_FOUND);
   }
}
