package com.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LoanService {

    private final LoanValidator loanValidator;
    private AuditService auditService;

    public LoanService(@Qualifier("incomeValidator") LoanValidator loanValidator) {
        this.loanValidator = loanValidator;
    }

    @Autowired
    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    public void applyLoan(double amount) {
        boolean approved = loanValidator.validateLoan(amount);
        auditService.audit("Loan Amount: " + amount + " Approved: " + approved);
    }
}