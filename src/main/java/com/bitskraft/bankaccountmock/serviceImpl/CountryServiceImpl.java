package com.bitskraft.bankaccountmock.serviceImpl;

import com.bitskraft.bankaccountmock.dto.CountryDTO;
import com.bitskraft.bankaccountmock.dto.StatesDTO;
import com.bitskraft.bankaccountmock.entity.Country;
import com.bitskraft.bankaccountmock.entity.States;
import com.bitskraft.bankaccountmock.repository.CountryRepository;
import com.bitskraft.bankaccountmock.service.CountryService;
import com.bitskraft.bankaccountmock.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;
    private StateService stateService;

    @Autowired
    CountryServiceImpl(CountryRepository countryRepository, StateService stateService) {
        this.countryRepository = countryRepository;
        this.stateService = stateService;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(int id) {
        return null;
    }

    @Override
    public void save(CountryDTO countryDTO) {
        Country country = new Country();
        country.setId(UUID.randomUUID().toString());
        country.setName(countryDTO.getName());
        country = countryRepository.save(country);
        stateService.save(countryDTO.getStates(), country);
    }
}
