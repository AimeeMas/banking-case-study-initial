package com.example.banking.repository;

import com.example.banking.model.Credit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreditRepository extends CrudRepository<Credit, Long> {

    List<Credit> findCreditByClientId(Long clientId);
}
