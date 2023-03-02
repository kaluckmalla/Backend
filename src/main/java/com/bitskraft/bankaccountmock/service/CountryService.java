package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.dto.CountryDTO;
import com.bitskraft.bankaccountmock.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {
    public List<Country> findAll();

    public Country findById(int id);

    public void save(CountryDTO countryDTO);
}
