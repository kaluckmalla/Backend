package com.bitskraft.bankaccountmock.serviceImpl;

import com.bitskraft.bankaccountmock.dto.StatesDTO;
import com.bitskraft.bankaccountmock.entity.Country;
import com.bitskraft.bankaccountmock.entity.District;
import com.bitskraft.bankaccountmock.entity.States;
import com.bitskraft.bankaccountmock.repository.StateRepository;
import com.bitskraft.bankaccountmock.service.DistrictService;
import com.bitskraft.bankaccountmock.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StateServiceImpl implements StateService {
    StateRepository stateRepository;
    DistrictService districtService;

    @Autowired
    StateServiceImpl(StateRepository stateRepository,DistrictService districtService) {
        this.stateRepository = stateRepository;
        this.districtService=districtService;
    }

    @Override
    public List<States> findAll() {
        return stateRepository.findAll();
    }

    @Override
    public StatesDTO findById(String id) {
        Optional<States> statesOptional=stateRepository.findById(id);
        StatesDTO statesDTO=new StatesDTO();
        States states=statesOptional.get();
        statesDTO.setName(states.getName());
        return statesDTO;
    }

    @Override
    public States findStateById(String id) {
        Optional<States> statesOptional=stateRepository.findById(id);
        States state=statesOptional.get();
        state.setName(state.getName());
        return state;
    }

    @Override
    public void save(List<StatesDTO> statesDTO, Country country) {
        for (StatesDTO dto : statesDTO) {
            States states = new States();
            states.setId(UUID.randomUUID().toString());
            states.setName(dto.getName());
            states.setCountry(country);
           states= stateRepository.save(states);
            districtService.save(dto.getDistricts(),states);
        }
    }

    @Override
    public void update(StatesDTO statesDTO, int id) {

    }
}
