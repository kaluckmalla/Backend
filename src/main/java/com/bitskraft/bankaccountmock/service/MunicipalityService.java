package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.dto.MunicipalityDTO;
import com.bitskraft.bankaccountmock.entity.District;
import com.bitskraft.bankaccountmock.entity.Municipality;

import java.util.List;

public interface MunicipalityService {
    public List<Municipality> findAll();
    public void save(List<MunicipalityDTO> municipalityDTOS, District district);
}
