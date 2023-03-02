package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.dto.DistrictDTO;
import com.bitskraft.bankaccountmock.entity.District;
import com.bitskraft.bankaccountmock.entity.States;

import java.util.List;

public interface DistrictService {
    public List<District> findAll();
    public void save(List<DistrictDTO> districts, States states);
}
