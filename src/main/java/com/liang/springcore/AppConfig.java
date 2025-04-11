package com.liang.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public Guitar guitar() {
        return new Guitar();
    }

    @Bean
    public Instrumentalist instrumentalist() {
        return new Instrumentalist(guitar());
    }



}
