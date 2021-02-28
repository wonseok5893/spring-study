package com.example.demo.xunit;

public class TestCaseTest extends TestCase {

    public TestCaseTest(String testMethod) {
        super(testMethod);
    }

    public void testTemplateMethod() {
        WasRun wasRun = new WasRun("testMethod");
        wasRun.run();
        Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
    }

}
