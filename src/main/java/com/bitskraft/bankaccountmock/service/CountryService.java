package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.dto.CountryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {
    public List<CountryDTO> findAll();

    public CountryDTO findById(int id);

    public void save(CountryDTO countryList);
}
