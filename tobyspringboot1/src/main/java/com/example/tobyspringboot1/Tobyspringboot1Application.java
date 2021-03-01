package com.example.tobyspringboot1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Tobyspringboot1Application {
    public static void main(String[] args) {
        SpringApplication.run(Tobyspringboot1Application.class, args);
    }
    /*
    CommandLineRunner
    ApplicationRunner 1.3
    의 차이
     */

    //인라인으로 빈을 정의하는 방법
    //이제는 @Configuration이 붙지 않아도 @Bean 등록 가능 / 하지만 동작방식이 다르다
    @Bean
    public CommandLineRunner myClRunner() {
        return args -> System.out.println("Hello AnnonyMous CommandLineRunner!!!");
    }
}