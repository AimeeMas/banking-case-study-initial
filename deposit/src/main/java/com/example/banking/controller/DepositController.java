package com.example.banking.controller;


import com.example.banking.model.Deposit;
import com.example.banking.service.DepositService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("deposit")
public class DepositController implements BasicController<Deposit> {

    private DepositService depositService;

    public DepositController(DepositService depositService) {

        this.depositService = depositService;
    }

    @Override
    @PostMapping(value = "createDeposit", produces = "application/json")
    public Deposit add(@RequestBody Deposit deposit) {

        return this.depositService.add(deposit);
    }

    @Override
    @GetMapping(value = "getDepositById/{id}", produces = "application/json")
    public Deposit get(@PathVariable("id") Long id) {
        Deposit deposit = this.depositService.get(id);

        return deposit;
    }

    @Override
    @PutMapping(value = "updateDeposit", produces = "application/json")
    public Deposit update(@RequestBody Deposit deposit) {

        return this.depositService.update(deposit);
    }

    @Override
    @DeleteMapping(value = "deleteDeposit", produces = "application/json")
    public boolean delete(@RequestBody Deposit deposit) {

        return this.depositService.delete(deposit);
    }

    @GetMapping("getLoansByClientId")
    public List<Deposit> getDepositByClientId(@RequestBody Long clientId) {
        return this.depositService.getDepositByClientId(clientId);
    }

    @Override
    @GetMapping(value = "getAllCredit", produces = "application/json")
    public List<Deposit> getAll() {

        List<Deposit> deposit = this.depositService.getAll();
        return deposit;

    }


}