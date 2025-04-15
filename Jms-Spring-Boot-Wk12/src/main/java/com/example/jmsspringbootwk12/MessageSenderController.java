package com.example.jmsspringbootwk12;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lab")
public class MessageSenderController {
    private final JmsTemplate jmsTemplate;
    public MessageSenderController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        jmsTemplate.convertAndSend("lab-queue", message);
        return "Message sent: " + message;
    }
    @PostMapping("/send/structured")
    public String sendStructured(@RequestBody StructuredMsg msg) {
        jmsTemplate.convertAndSend("lab-queue", msg);
        return "Structured message sent!";
    }
}
