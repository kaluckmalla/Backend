package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.dto.CountryDTO;
import com.bitskraft.bankaccountmock.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CountryService {
    public List<Country> findAll();

    public CountryDTO findById(int id);

    public  Country findCountryById(int id);
    public void save(CountryDTO countryDTO);
}
