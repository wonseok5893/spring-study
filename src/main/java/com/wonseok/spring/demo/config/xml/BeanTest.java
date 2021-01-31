package com.wonseok.spring.demo.config.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

public class BeanTest {

    private BeanDto beanDto;

    public BeanTest(BeanDto beanDto) {
        this.beanDto = beanDto;
    }

    public BeanDto byNameInjection(){
        return beanDto;
    }

}
