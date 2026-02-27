package com.prac;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class TransactionLogger {

    @PostConstruct
    public void init() {
        System.out.println("Logger initialized");
    }

    public void logTransaction(double amount) {
        System.out.println("Transaction logged: " + amount);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Logger destroyed");
    }
}
