package com.example.assignment1_28_02_26.service;

import java.time.LocalDate;
import java.util.List;
import com.example.assignment1_28_02_26.Loan;

public interface LoanService {

    void issueBook(Long memberId, Long bookId, LocalDate dueDate);

    void returnBook(Long loanId);

    Loan getLoanById(Long loanId);

    List<Loan> getLoansByMember(Long memberId);

    List<Loan> getAllLoans();
}