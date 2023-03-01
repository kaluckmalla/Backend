package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.dto.StatesDTO;
import com.bitskraft.bankaccountmock.entity.States;

import java.util.List;

public interface StateService {
    public List<States> findAll();
    public StatesDTO findById(int id);
    public void save(StatesDTO statesDTO);
    public void update(StatesDTO statesDTO, int id);
}
