package com.wonseok.spring.demo.config.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig2 {
    @Bean
    public MyBean myBean(){
        return new MyBeanImp();
    }
}
