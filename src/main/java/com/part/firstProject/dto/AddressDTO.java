package com.part.firstProject.dto;

import com.part.firstProject.entity.Country;
import com.part.firstProject.entity.District;
import com.part.firstProject.entity.Municipality;
import com.part.firstProject.entity.States;

import java.util.List;

public class AddressDTO {
     private int id;
        private List<Country> country;
        private List<District> district;
        private List<States> states;
        private List<Municipality> municipality;
}
