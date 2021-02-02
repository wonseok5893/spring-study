package com.wonseok.spring.demo.config.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanUser {

    private BeanTest beanTest;
    private BeanDto beanDto;

    public static void main(String[] args) {

        ApplicationContext context = new GenericXmlApplicationContext("xml/bean.xml");
        BeanDto beanDto = (BeanDto) context.getBean("beanDto");

        BeanTest beanTest = (BeanTest) context.getBean("beanTest");
        System.out.println(beanDto==beanTest.byNameInjection());
        // true 반환 -> single ton 객체
    }
}
