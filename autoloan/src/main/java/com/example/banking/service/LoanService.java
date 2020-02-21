package com.example.banking.service;

import com.example.banking.model.Loan;
import com.example.banking.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService implements BasicService<Loan> {

    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan add(Loan loan) {

        return this.loanRepository.save(loan);
    }

    @Override
    public Loan get(Long id) {

        Optional optional = this.loanRepository.findById(id);

        Loan result = null;
        if(optional.isPresent()){
            result = (Loan) optional.get();
        }
        return result;
    }

    @Override
    public Loan update(Loan loan) {

        return this.loanRepository.save(loan);
    }

    @Override
    public boolean delete(Loan loan) {

        this.loanRepository.delete(loan);
        return true;
    }

    @Override
    public List<Loan> getAll() {
        return (List<Loan>) this.loanRepository.findAll();
    }

    public List<Loan> getLoanByClientId(Long clientId){

        return this.loanRepository.findLoanByClientId(clientId);
    }
}
