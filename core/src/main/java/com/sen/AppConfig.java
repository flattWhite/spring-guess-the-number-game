package com.sen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.sen")
public class AppConfig {

    // Define beans
    @Bean
    public NumberGenerator numberGenerator(){
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game(){
        return new GameImpl();
    }
}
