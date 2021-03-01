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
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Tobyspringboot1Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(Tobyspringboot1Application.class, args);
        //가장 low 레벨의 ApplicationContext
        ac.addApplicationListener(new ApplicationListener<MyEvent>() {
            @Override
            public void onApplicationEvent(MyEvent event) {
                System.out.println("Hello ApplicationEvent: " + event.getMessage());
            }
        });
        ac.publishEvent(new MyEvent(ac,"TobySpringBoot Event"));
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
}