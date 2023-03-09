package com.bitskraft.bankaccountmock.serviceImpl;

import com.bitskraft.bankaccountmock.dto.AddressDTO;
import com.bitskraft.bankaccountmock.dto.CountryDTO;
import com.bitskraft.bankaccountmock.entity.*;
import com.bitskraft.bankaccountmock.repository.AddressRepository;
import com.bitskraft.bankaccountmock.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {
    AddressRepository addressRepository;
    CountryService countryService;
    StateService stateService;
    DistrictService districtService;
    MunicipalityService municipalityService;
    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, CountryService countryService,
                              StateService stateService, DistrictService districtService, MunicipalityService municipalityService) {
        this.addressRepository = addressRepository;
        this.countryService = countryService;
        this.stateService = stateService;
        this.districtService = districtService;
        this.municipalityService = municipalityService;
    }
    @Override
    public List<Address> findAll() {
          return  addressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(int id) {
        return addressRepository.findById(id);
    }
    @Override
    public void save(AddressDTO addressDTO) {
        Address address = new Address();
        Country country = countryService.findCountryById(addressDTO.getCountry());
        States states=stateService.findStateById(addressDTO.getStates());
        District district=districtService.findDistrictById(addressDTO.getDistricts());
        Municipality municipality=municipalityService.findMunicipalityById(addressDTO.getMunicipalities());
        address.setCountry(country);
        address.setStates(states);
        address.setDistricts(district);
        address.setMunicipalities(municipality);
        addressRepository.save(address);
    }

}
