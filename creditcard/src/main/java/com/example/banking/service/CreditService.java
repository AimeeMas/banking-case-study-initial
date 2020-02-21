package com.example.banking.service;

import com.example.banking.model.Credit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService implements BasicService<Credit>{

    private CreditService CreditRepository;

    public CreditService(CreditService creditRepository) {
        CreditRepository = creditRepository;
    }

    @Override
    public Credit add(Credit credit) {
        return null;
    }

    @Override
    public Credit get(Long id) {
        return null;
    }

    @Override
    public Credit update(Credit credit) {
        return null;
    }

    @Override
    public boolean delete(Credit credit) {
        return false;
    }

    @Override
    public List<Credit> getAll() {
        return null;
    }

    public List<Credit> getCreditByClientId(Long clientId){

        return this.CreditRepository.findCreditByClientId(clientId);
    }
}
