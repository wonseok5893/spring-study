package com.example.tobyspringboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tobyspringboot1Application {
    public static void main(String[] args)
    {
        System.out.println("Hello1");
        SpringApplication.run(Tobyspringboot1Application.class, args);
        System.out.println("Hello2");
    }

}
