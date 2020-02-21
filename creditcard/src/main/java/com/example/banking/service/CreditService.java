package com.example.banking.service;

import com.example.banking.model.Credit;
import com.example.banking.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditService implements BasicService<Credit>{

    private CreditRepository creditRepository;

    public CreditService(CreditRepository creditRepository) {

        this.creditRepository = creditRepository;
    }

    @Override
    public Credit add(Credit credit) {

        return this.creditRepository.save(credit);
    }

    @Override
    public Credit get(Long id) {

        Optional optional = this.creditRepository.findById(id);

        Credit result = null;
        if(optional.isPresent()){
            result = (Credit) optional.get();
        }
        return result;
    }

    @Override
    public Credit update(Credit credit) {

        return this.creditRepository.save(credit);
    }

    @Override
    public boolean delete(Credit credit) {

        this.creditRepository.delete(credit);
        return true;
    }

    @Override
    public List<Credit> getAll() {

        return (List<Credit>) this.creditRepository.findAll();
    }

    public List<Credit> getCreditByClientId(Long clientId){

        return this.creditRepository.findCreditByClientId(clientId);
    }
}
