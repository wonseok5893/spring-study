package com.example.demo.xunit;

public class TestCaseTest extends TestCase {

    public TestCaseTest(String testMethod) {
        super(testMethod);
    }

    public void testRunning() {
        WasRun wasRun = new WasRun("testMethod");
        Assert.assertEquals(false, wasRun.wasRun);
        wasRun.run();
        Assert.assertEquals(true, wasRun.wasRun);
    }
}
