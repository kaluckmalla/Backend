//package com.bitskraft.bankaccountmock.service;
//
//import com.bitskraft.bankaccountmock.dto.CountryDTO;
//import com.bitskraft.bankaccountmock.repository.CountryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CountryServiceImpl implements CountryService {
//    CountryRepository countryRepository;
//    @Autowired
//    CountryServiceImpl(CountryRepository countryRepository){
//        this.countryRepository=countryRepository;
//    }
//    @Override
//    public List<CountryDTO> findAll() {
////     List<CountryDTO> countryDTOS= countryRepository.findAll();
////        if(countryDTOS.size()>0){
////            return countryDTOS;
////        }else{
////            return new ArrayList<CountryDTO>();
////        }
//        return null;
//    }
//
//    @Override
//    public CountryDTO findById(int id) {
//        return null;
//    }
//
//    @Override
//    public void save(CountryDTO countryList) {
//            countryRepository.save(countryList);
//    }
//}
