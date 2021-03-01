package com.example.tobyspringboot1;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringBootApplication
public class Tobyspringboot1Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(Tobyspringboot1Application.class, args);
        //가장 low 레벨의 ApplicationContext
        //순서: startedEvent -> CommandRunner -> ApplicationRunner -> readyEvent
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onMyEvent() {
        System.out.println("Application Ready!!!");
    }
}