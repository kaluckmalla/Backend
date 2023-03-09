package com.bitskraft.bankaccountmock.serviceImpl;

import com.bitskraft.bankaccountmock.dto.DistrictDTO;
import com.bitskraft.bankaccountmock.dto.StatesDTO;
import com.bitskraft.bankaccountmock.entity.District;
import com.bitskraft.bankaccountmock.entity.States;
import com.bitskraft.bankaccountmock.repository.DistrictRepository;
import com.bitskraft.bankaccountmock.service.DistrictService;
import com.bitskraft.bankaccountmock.service.MunicipalityService;
import com.bitskraft.bankaccountmock.service.StateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DistrictServiceImpl implements DistrictService {

    DistrictRepository districtRepository;
    MunicipalityService municipalityService;
    StateService stateService;
    DistrictServiceImpl(DistrictRepository districtRepository,MunicipalityService municipalityService,
                        StateService stateService){
        this.districtRepository=districtRepository;
        this.municipalityService=municipalityService;
        this.stateService=stateService;
    }
    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }
    @Override
    public DistrictDTO findById(String id) {
        Optional<District> districtOptional = districtRepository.findById(id);
        DistrictDTO districtDTO = new DistrictDTO();
        District district=districtOptional.get();
        districtDTO.setName(district.getName());
        return districtDTO;
    }

    @Override
    public District findDistrictById(String id) {
        Optional<District> districtOptional = districtRepository.findById(id);
        District district=districtOptional.get();
        district.setName(district.getName());
        return district;
    }

    @Override
    public District findDistrictByStateId(String id) {
        return null;
    }


    @Override
    public void save(List<DistrictDTO> districts, States states) {
        for(DistrictDTO districtDTO:districts){
             District district=new District();
             district.setId(UUID.randomUUID().toString());
             district.setName(districtDTO.getName());
            district.setStates(states);
            district= districtRepository.save(district);
            municipalityService.save(districtDTO.getMunicipalities(),district);
        }

    }
}
