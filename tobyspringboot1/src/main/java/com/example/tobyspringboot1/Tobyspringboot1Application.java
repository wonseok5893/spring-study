package com.example.tobyspringboot1;

import org.springframework.boot.ApplicationRunner;
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
    CommandLineRunner, -> args를 받을 때 실행됨
    ApplicationRunner, 1.3 에 도입-> SpringApplication.run()이 실행될때 실행됨
    의 차이
     */

    //인라인으로 빈을 정의하는 방법
    //이제는 @Configuration이 붙지 않아도 @Bean 등록 가능 / 하지만 동작방식이 다르다
    @Bean
    public ApplicationRunner myClRunner() {
        return args -> System.out.println("Hello AnnonyMous CommandLineRunner!!!");
    }
}