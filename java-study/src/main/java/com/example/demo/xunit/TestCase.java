package com.example.demo.xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase implements Test{
    protected final String name;

    public TestCase(String testMethod) {
        this.name = testMethod;
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.add(new TestCaseTest("testTemplateMethod"));
        suite.add(new TestCaseTest("testResult"));
        suite.add(new TestCaseTest("testFailedResultFormatting"));
        suite.add(new TestCaseTest("testFailedResult"));
        suite.add(new TestCaseTest("testSuite"));
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
