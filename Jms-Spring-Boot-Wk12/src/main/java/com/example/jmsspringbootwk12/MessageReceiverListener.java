package com.example.jmsspringbootwk12;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiverListener {
    @JmsListener(destination = "lab-queue")
    public void receiveMessage(StructuredMsg msg) {
        System.out.println("Received structured message: " + msg);
    }
}
