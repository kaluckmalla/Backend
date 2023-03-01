package com.bitskraft.bankaccountmock.service;

import com.bitskraft.bankaccountmock.dto.StatesDTO;
import com.bitskraft.bankaccountmock.entity.States;
import com.bitskraft.bankaccountmock.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {
    StateRepository stateRepository;
    @Autowired
    StateServiceImpl(StateRepository stateRepository){
        this.stateRepository=stateRepository;
    }
    @Override
    public List<States> findAll() {
        return stateRepository.findAll();
    }

    @Override
    public StatesDTO findById(int id) {
        return null;
    }

    @Override
    public void save(StatesDTO statesDTO) {

    }

    @Override
    public void update(StatesDTO statesDTO, int id) {

    }
}
