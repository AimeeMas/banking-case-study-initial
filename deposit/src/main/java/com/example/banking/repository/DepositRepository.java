package com.example.banking.repository;


import com.example.banking.model.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepositRepository extends CrudRepository<Deposit, Long> {

    List<Deposit> findDepositByClientId(Long clientId);
}
