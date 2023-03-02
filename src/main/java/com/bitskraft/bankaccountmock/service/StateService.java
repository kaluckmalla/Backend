package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.dto.StatesDTO;
import com.bitskraft.bankaccountmock.entity.Country;
import com.bitskraft.bankaccountmock.entity.States;

import java.util.List;

public interface StateService {
    public List<States> findAll();
    public StatesDTO findById(int id);
    public void save (List<StatesDTO> statesDTO, Country country);
    public void update(StatesDTO statesDTO, int id);
}
