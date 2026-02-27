package com.prac;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpiPayment implements PaymentService {

    private final TransactionLogger logger;

    public UpiPayment(TransactionLogger logger) {
        this.logger = logger;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("UPI Payment: " + amount);
        logger.logTransaction(amount);
    }
}