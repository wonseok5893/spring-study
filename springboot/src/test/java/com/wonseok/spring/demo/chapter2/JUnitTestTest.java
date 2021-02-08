package com.wonseok.spring.demo.chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
public class JUnitTestTest {

    static JUnitTest testObject;

    @Test
    public void test1(){
        assertThat(this,is(not(sameInstance(testObject))));
    }
    @Test
    public void test2(){
        assertThat(this,is(not(sameInstance(testObject))));
    }
    @Test
    public void test3(){
        assertThat(this,is(not(sameInstance(testObject))));
    }
}