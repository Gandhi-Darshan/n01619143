package Config;

import Service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class AppConfig {
    @Bean
    @Scope("prototype")
    public GreetingService greetingService() {
        return new GreetingService();
    }
}
