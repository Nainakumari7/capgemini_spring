package com.prac;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class CreditCardPayment implements PaymentService {

    private final TransactionLogger logger;

    public CreditCardPayment(TransactionLogger logger) {
        this.logger = logger;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card Payment: " + amount);
        logger.logTransaction(amount);
    }
}