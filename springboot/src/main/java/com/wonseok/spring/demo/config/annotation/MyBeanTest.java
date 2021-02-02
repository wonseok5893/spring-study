package com.wonseok.spring.demo.config.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyBeanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        MyBean myBean = context.getBean(MyBean.class);
        System.out.println(myBean.getClass());
        System.out.println(myBean.getName());

    }
}
