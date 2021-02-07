package com.wonseok.spring.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class PropertyTestTest {
    @Autowired
    Environment environment;

    @Test
    public void contextLoads(){
        assertEquals(environment.getProperty("spring.datasource.username"),"sa"); //success
//        assertEquals(environment.getProperty("spring.datasource.username"),"sa1"); //fail
    }
}