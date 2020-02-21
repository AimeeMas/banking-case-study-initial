package com.example.banking.repository;

import com.example.banking.model.Loan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loan, Long>{

    List<Loan> findLoanByClientId(Long clientId);
}
