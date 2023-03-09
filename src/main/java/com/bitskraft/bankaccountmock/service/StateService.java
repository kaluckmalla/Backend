package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.dto.StatesDTO;
import com.bitskraft.bankaccountmock.entity.Country;
import com.bitskraft.bankaccountmock.entity.States;

import java.util.List;
import java.util.Optional;

public interface StateService {
    public List<States> findAll();
    public StatesDTO findById(String id);

    public States findStateById(String id);
    public void save (List<StatesDTO> statesDTO, Country country);
    public void update(StatesDTO statesDTO, int id);
}
