package com.bitskraft.bankaccountmock.repository;

import com.bitskraft.bankaccountmock.entity.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality,String> {
}
