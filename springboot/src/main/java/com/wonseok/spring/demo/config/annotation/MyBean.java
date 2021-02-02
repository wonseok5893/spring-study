package com.wonseok.spring.demo.config.annotation;

public interface MyBean {
    final String name = "Wonseok";
    default String getName(){return name;}

}
