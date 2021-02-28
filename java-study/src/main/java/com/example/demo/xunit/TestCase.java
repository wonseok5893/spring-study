package com.example.demo.xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase implements Test{
    protected final String name;

    public TestCase(String testMethod) {
        this.name = testMethod;
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite(TestCaseTest.class);
        // 테스트 메소드 아에 test가 붙어있는 메소드를 testsuite로 하자는 관례
        return suite;
    }

    public void run(TestResult result) {
        result.testStarted();
        setUp();
        try {
            Method method = getClass().getMethod(name);
            method.invoke(this);
        } catch (Exception e) {
           result.testFailed();
        }
        tearDown();
    }

    public void tearDown() {

    }

    public void setUp() {

    }

}
