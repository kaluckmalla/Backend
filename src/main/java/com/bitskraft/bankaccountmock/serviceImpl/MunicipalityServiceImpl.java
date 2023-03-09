package com.bitskraft.bankaccountmock.serviceImpl;

import com.bitskraft.bankaccountmock.dto.MunicipalityDTO;
import com.bitskraft.bankaccountmock.entity.District;
import com.bitskraft.bankaccountmock.entity.Municipality;
import com.bitskraft.bankaccountmock.repository.MunicipalityRepository;
import com.bitskraft.bankaccountmock.service.MunicipalityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public MunicipalityDTO findById(String id) {
         Optional<Municipality> municipalityOptional=municipalityRepository.findById(id);
         MunicipalityDTO municipalityDTO=new MunicipalityDTO();
         Municipality municipality=municipalityOptional.get();
         municipalityDTO.setName(municipality.getName());
         municipalityDTO.setType(municipality.getType());
         return municipalityDTO;
    }

    @Override
    public Municipality findMunicipalityById(String id) {
        Optional<Municipality> municipalityOptional=municipalityRepository.findById(id);
        Municipality municipality=municipalityOptional.get();
        municipality.setName(municipality.getName());
        municipality.setType(municipality.getType());
        return municipality;
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
