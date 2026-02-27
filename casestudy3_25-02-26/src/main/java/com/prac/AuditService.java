package com.prac;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AuditService {

    @PostConstruct
    public void init() {
        System.out.println("Audit Service Started");
    }

    public void audit(String message) {
        System.out.println("Audit Log: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Audit Service Stopped");
    }
}