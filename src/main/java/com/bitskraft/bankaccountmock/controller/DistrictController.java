package com.bitskraft.bankaccountmock.controller;

import com.bitskraft.bankaccountmock.entity.District;
import com.bitskraft.bankaccountmock.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DistrictController {
    @Autowired
    DistrictService districtService;

    @GetMapping("/districtDetails")
    public ResponseEntity<?> findAll(){
        List<District> districtList=districtService.findAll();
        return new ResponseEntity<>(districtList,districtList.size()>0? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
    @GetMapping("/districtDetails/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        try{
            return new ResponseEntity<>(districtService.findDistrictById(id),HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
