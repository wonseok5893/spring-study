package com.example.demo.xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WasRun extends TestCase {
    public boolean wasSetUp;
    boolean wasRun;

    public WasRun(String testMethod) {
        super(testMethod);
    }

    public void testMethod() {
        wasRun = true;
    }

    @Override
    public void setUp() {
        wasSetUp = true;
    }
}
