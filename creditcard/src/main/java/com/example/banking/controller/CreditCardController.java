package com.example.banking.controller;

import com.example.banking.model.Credit;
import com.example.banking.service.CreditService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("credit")
public class CreditCardController implements BasicController<Credit> {

    private CreditService loanService;

    public CreditCardController(CreditService creditService) {

        this.creditService = creditService;
    }

    @Override
    @PostMapping(value = "createLoan", produces = "application/json")
    public Loan add(@RequestBody Loan loan) {

        return this.loanService.add(loan);
    }

    @Override
    @GetMapping(value = "getLoanById/{id}", produces = "application/json")
    public Loan get(@PathVariable("id") Long id) {
        Loan loan = this.loanService.get(id);

        return loan;
    }

    @Override
    @PutMapping(value = "updateLoan", produces = "application/json")
    public Loan modify(@RequestBody Loan loan) {

        return this.loanService.update(loan);
    }

    @Override
    @DeleteMapping(value = "deleteLoan", produces = "application/json")
    public boolean delete(@RequestBody Loan loan) {

        return this.loanService.delete(loan);
    }

    @GetMapping("getLoansByClientId")
    public List<Loan> getLoansByClientId(@RequestBody Long clientId) {
        return this.loanService.getLoanByClientId(clientId);
    }

    @Override
    @GetMapping(value = "getAllLoans", produces = "application/json")
    public List<Loan> getAll() {

        List<Loan> loans = this.loanService.getAll();
        return loans;

    }


}