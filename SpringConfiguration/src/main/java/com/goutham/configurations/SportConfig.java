package com.goutham.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sports.properties")
@ComponentScan("com.goutham.configurations")
public class SportConfig {
    @Bean
    public FortuneService sadFortuneService()
    {
        return new SadFortuneService();
    }
    @Bean
    public Coach swimCoach()
    {
        return new SwimCoach(sadFortuneService());
    }
}
