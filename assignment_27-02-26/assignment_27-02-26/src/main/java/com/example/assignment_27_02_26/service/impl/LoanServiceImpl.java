package com.example.assignment_27_02_26.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.assignment_27_02_26.DAO.LoanRepository;
import com.example.assignment_27_02_26.entity.Loan;
import com.example.assignment_27_02_26.exception.ResourceNotFoundException;
import com.example.assignment_27_02_26.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan issueLoan(Loan loan) {
        loan.setIssueDate(LocalDate.now());
        return loanRepository.save(loan);
    }

    @Override
    public Loan returnLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        loan.setReturnDate(LocalDate.now());
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}