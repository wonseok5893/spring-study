package com.wonseok.spring.demo.config.xml;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class BeanTestTest {


    @Test
    void byAutoWireNameInjectionTest(){
        // IOC에서 가져온 bean 객체
        ApplicationContext applicationContext = new GenericXmlApplicationContext("../bean.xml");
        BeanDto beanDto = (BeanDto) applicationContext.getBean("beanDto");
        // 주입 받은 객체 bean 객체

    }

}