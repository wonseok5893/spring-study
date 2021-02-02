package com.wonseok.spring.demo.config.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public MyBean myBean(){
        return new MyBeanImp();
    }
}
