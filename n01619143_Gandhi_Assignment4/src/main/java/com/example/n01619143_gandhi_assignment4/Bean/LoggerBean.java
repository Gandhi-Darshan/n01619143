package com.example.n01619143_gandhi_assignment4.Bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;

@Stateless
public class LoggerBean {

    @PostConstruct
    public void init() {
        System.out.println("LoggerBean init");
    }

    public void log(String action) {
        System.out.println("Action LoggerBean: " + action);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("LoggerBean destroy");
    }
}
