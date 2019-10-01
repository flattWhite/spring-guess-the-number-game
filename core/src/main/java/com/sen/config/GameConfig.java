package com.sen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    // == fields ==
    private int maxNumber = 50;
    private int guessCount = 10;

    // == bean methods ==
    @Bean
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    public int guessCount(){
        return guessCount;
    }
}
