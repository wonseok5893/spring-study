package com.example.demo.xunit;

public class TestCaseTest extends TestCase {

    public TestCaseTest(String testMethod) {
        super(testMethod);
    }

    public void testRunning() {
        WasRun wasRun = new WasRun("testMethod");
        System.out.println(wasRun.wasRun);
        wasRun.run();
        System.out.println(wasRun.wasRun);
    }
}
