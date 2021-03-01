package com.example.tobyspringboot1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
}
@Component
class MyClRunner implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello CommandLineRunner");
    }
}