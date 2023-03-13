package com.bitskraft.bankaccountmock.controller;

import com.bitskraft.bankaccountmock.entity.District;
import com.bitskraft.bankaccountmock.entity.States;
import com.bitskraft.bankaccountmock.service.DistrictService;
import com.bitskraft.bankaccountmock.service.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DistrictController {
    @Autowired
    DistrictService districtService;
    MunicipalityService municipalityService;
    DistrictController(DistrictService districtService,MunicipalityService municipalityService){
        this.districtService=districtService;
        this.municipalityService=municipalityService;
    }
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
    @GetMapping("/districtFromState/{id}")
    public ResponseEntity<?> findDistrictByStateId(@PathVariable String id){
        try{
            return new ResponseEntity<>(districtService.findDistrictByStateId(id),HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/municipalityFromDistrict/{id}")
    public ResponseEntity<?> findMunicipalityByDistrictId(@PathVariable String id){
        try{
            return new ResponseEntity<>(municipalityService.findMunicipalityByDistrictId(id),HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
