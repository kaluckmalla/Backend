package com.bitskraft.bankaccountmock.repository;

import com.bitskraft.bankaccountmock.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);
}
