package com.bitskraft.bankaccountmock.serviceImpl;

import com.bitskraft.bankaccountmock.dto.MunicipalityDTO;
import com.bitskraft.bankaccountmock.entity.District;
import com.bitskraft.bankaccountmock.entity.Municipality;
import com.bitskraft.bankaccountmock.repository.MunicipalityRepository;
import com.bitskraft.bankaccountmock.service.MunicipalityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {
    MunicipalityRepository municipalityRepository;
    MunicipalityServiceImpl(MunicipalityRepository municipalityRepository){
        this.municipalityRepository=municipalityRepository;
    }
    @Override
    public List<Municipality> findAll() {
        return municipalityRepository.findAll();
    }

    @Override
    public void save(List<MunicipalityDTO> municipalityDTOS, District district) {
           for(MunicipalityDTO municipalityDTO:municipalityDTOS){
               Municipality municipality=new Municipality();
               municipality.setId(UUID.randomUUID().toString());
               municipality.setName(municipalityDTO.getName());
               municipality.setType(municipalityDTO.getType());
               municipality.setDistricts(district);
               municipalityRepository.save(municipality);
           }
    }
}
