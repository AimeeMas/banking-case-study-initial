package com.example.banking.service;

import com.example.banking.model.Deposit;
import com.example.banking.repository.DepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositService implements BasicService<Deposit>{

    private DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {

        this.depositRepository = depositRepository;
    }

    @Override
    public Deposit add(Deposit deposit) {

        return this.depositRepository.save(deposit);
    }

    @Override
    public Deposit get(Long id) {

        Optional optional = this.depositRepository.findById(id);

        Deposit result = null;
        if(optional.isPresent()){
            result = (Deposit) optional.get();
        }
        return result;
    }

    @Override
    public Deposit update(Deposit deposit) {

        return this.depositRepository.save(deposit);
    }

    @Override
    public boolean delete(Deposit deposit) {

        this.depositRepository.delete(deposit);
        return true;
    }

    @Override
    public List<Deposit> getAll() {

        return (List<Deposit>) this.depositRepository.findAll();
    }

    public List<Deposit> getDepositByClientId(Long clientId){

        return this.depositRepository.findDepositByClientId(clientId);
    }
}
