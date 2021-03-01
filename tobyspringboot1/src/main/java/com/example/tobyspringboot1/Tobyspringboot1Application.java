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

        ac.publishEvent(new MyEvent(ac,"TobySpringBoot Event"));
    }

    @MyEventListener
    public void onMyEvent(MyEvent event) {
        System.out.println("Hello My Event");
    }

    static class MyEvent extends ApplicationEvent {

        private final String message;

        public MyEvent(Object source, String message) {
            super(source);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @EventListener // 내가 만든 EventListener 에도 붙여서 사용,
    public @interface MyEventListener {

    }
}