package com.example.assignment_27_02_26.service;

import java.util.List;
import com.example.assignment_27_02_26.entity.Loan;

public interface LoanService {

    Loan issueLoan(Loan loan);

    Loan returnLoan(Long loanId);

    List<Loan> getAllLoans();
}