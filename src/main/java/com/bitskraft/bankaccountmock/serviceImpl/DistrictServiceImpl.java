package com.bitskraft.bankaccountmock.serviceImpl;

import com.bitskraft.bankaccountmock.dto.DistrictDTO;
import com.bitskraft.bankaccountmock.entity.District;
import com.bitskraft.bankaccountmock.entity.States;
import com.bitskraft.bankaccountmock.repository.DistrictRepository;
import com.bitskraft.bankaccountmock.service.DistrictService;
import com.bitskraft.bankaccountmock.service.MunicipalityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DistrictServiceImpl implements DistrictService {

    DistrictRepository districtRepository;
    MunicipalityService municipalityService;
    DistrictServiceImpl(DistrictRepository districtRepository,MunicipalityService municipalityService){
        this.districtRepository=districtRepository;
        this.municipalityService=municipalityService;
    }
    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
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
