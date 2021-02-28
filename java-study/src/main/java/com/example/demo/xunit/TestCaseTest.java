package com.example.demo.xunit;

public class TestCaseTest extends TestCase {

    public TestCaseTest(String testMethod) {
        super(testMethod);
    }

    WasRun wasRun;
    @Override
    public void setUp() {
        wasRun = new WasRun("testMethod");
    }

    public void testTemplateMethod() {
        Assert.assertEquals(false, wasRun.wasRun);
        wasRun.run();
        Assert.assertEquals("setUp testMethod", wasRun.log);
        Assert.assertEquals(true, wasRun.wasRun);
    }

}
