package com.example.week2;

import Config.AppConfig;
import Service.GreetingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Week2Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Inject dependencies
        GreetingPrinter printer = new GreetingPrinter(context.getBean(GreetingService.class));
        printer.printGreeting();

        // Test scope behavior
        GreetingService service1 = context.getBean(GreetingService.class);
        GreetingService service2 = context.getBean(GreetingService.class);
        System.out.println("Are beans equal? " + (service1 == service2));


        context.close(); // Ensures @PreDestroy is triggered
    }
}
