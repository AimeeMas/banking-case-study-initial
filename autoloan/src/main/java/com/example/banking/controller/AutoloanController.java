package com.example.banking.controller;
import com.example.banking.model.Loan;
import com.example.banking.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autoloan/createLoan")
public class AutoloanController {

    private LoanService loanService;

    public AutoloanController(LoanService loanService) {

        this.loanService = loanService;
    }


    @PostMapping(value = "autoloan/createLoan", produces = "application/json")
    public Loan add(@RequestBody Loan loan) {

        return this.loanService.add(loan);
    }

    @GetMapping(value = "getLoanById/{id}", produces = "application/json")
    public Loan get(@PathVariable("id") Long id) {
        Loan loan = this.loanService.get(id);

        return loan;
    }

    @PutMapping(value = "updateLoan", produces = "application/json")
    public Loan update(@RequestBody Loan loan) {

        return this.loanService.update(loan);
    }

    @DeleteMapping(value = "autoloan/deleteLoan/{id}", produces = "application/json")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {

        Boolean success = this.loanService.delete(get(id));
        HttpStatus status;
        String message = "";

        if(success) {
            status = HttpStatus.NO_CONTENT;
            message = "Successfully deleted.";
        } else {
            status = HttpStatus.NOT_FOUND;
            message = "No accounts available to show currently.";
        }

        return new ResponseEntity(message, status);

    }

    @GetMapping("getLoansByClientId")
    public List<Loan> getLoansByClientId(@RequestBody Long clientId) {
        return this.loanService.getLoanByClientId(clientId);
    }

    @GetMapping(value = "getAllLoans", produces = "application/json")
    public List<Loan> getAll() {

        List<Loan> loans = this.loanService.getAll();
        return loans;

    }
}
