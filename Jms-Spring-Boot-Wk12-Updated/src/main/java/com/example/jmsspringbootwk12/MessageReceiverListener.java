package com.example.jmsspringbootwk12;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiverListener {
    @JmsListener(destination = "lab-queue")
    public void receiveMessage(StructuredMsg message) {
        System.out.println("Received message in listener: " +
                message);
        System.out.println("From: " + message.getName());
        System.out.println("Message: " + message.getMessage());
    }
}
