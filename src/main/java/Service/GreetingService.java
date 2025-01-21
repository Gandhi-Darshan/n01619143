package Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class GreetingService {
    public String getGreeting() {
        return "Hello, Spring Beans!";
    }

    @PostConstruct
    public void init() {
        System.out.println("GreetingService bean initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("GreetingService bean destroyed.");
    }
}
