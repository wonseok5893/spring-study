package com.example.demo.xunit;

public class TestResult {
    int runCount = 0;
    int errCount = 0;

    public void testStarted() {
        runCount++;
    }

    public void testFailed() {
        errCount++;
    }

    public String getSummary() {
        return runCount+" run, "+errCount+" failed";
    }

}
