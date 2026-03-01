package com.example.assignment_27_02_26.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.assignment_27_02_26.entity.Loan;
import com.example.assignment_27_02_26.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public Loan issueLoan(@RequestBody Loan loan) {
        return loanService.issueLoan(loan);
    }

    @PutMapping("/return/{id}")
    public Loan returnLoan(@PathVariable Long id) {
        return loanService.returnLoan(id);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }
}