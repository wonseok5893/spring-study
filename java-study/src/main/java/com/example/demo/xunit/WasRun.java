package com.example.demo.xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WasRun extends TestCase {
    public boolean wasSetUp;
    public String log;
    boolean wasRun;

    public WasRun(String testMethod) {
        super(testMethod);
    }


    @Override
    public void setUp() {
        log = "setUp";
    }

    public void testMethod() {
        log += " testMethod";
    }

    @Override
    public void tearDown() {
        log += " tearDown";
    }
}
