package com.bitskraft.bankaccountmock.controller;

import com.bitskraft.bankaccountmock.entity.States;
import com.bitskraft.bankaccountmock.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StateController {
    @Autowired
    StateService stateService;
    @GetMapping("/stateDetails")
    public ResponseEntity<?> finAll(){
        List<States> statesList=stateService.findAll();
        return  new ResponseEntity<>(statesList, statesList.size()>0?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @GetMapping("/stateDetails/{id}")
    public ResponseEntity<?> finById(@PathVariable("id")String id){
        try{
            return new ResponseEntity<>(stateService.findById(id),HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
