package com.example.banking.controller;

import com.example.banking.model.Credit;
import com.example.banking.service.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("credit")
public class CreditCardController implements BasicController<Credit> {

    private CreditService creditService;

    public CreditCardController(CreditService creditService) {

        this.creditService = creditService;
    }

    @Override
    @PostMapping(value = "createCredit", produces = "application/json")
    public Credit add(@RequestBody Credit credit) {

        return this.creditService.add(credit);
    }

    @Override
    @GetMapping(value = "getCreditById/{id}", produces = "application/json")
    public Credit get(@PathVariable("id") Long id) {
        Credit credit = this.creditService.get(id);

        return credit;
    }

    @Override
    @PutMapping(value = "updateCredit", produces = "application/json")
    public Credit update(@RequestBody Credit credit) {

        return this.creditService.update(credit);
    }

    @Override
    @DeleteMapping(value = "deleteCredit", produces = "application/json")
    public boolean delete(@RequestBody Credit credit) {

        return this.creditService.delete(credit);
    }

    @GetMapping("getLoansByClientId")
    public List<Credit> getCreditByClientId(@RequestBody Long clientId) {
        return this.creditService.getCreditByClientId(clientId);
    }

    @Override
    @GetMapping(value = "getAllCredit", produces = "application/json")
    public List<Credit> getAll() {

        List<Credit> credit = this.creditService.getAll();
        return credit;

    }


}