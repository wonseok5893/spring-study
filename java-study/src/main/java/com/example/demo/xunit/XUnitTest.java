package com.example.demo.xunit;

public class XUnitTest {
    public static void main(String[] args) {
        TestSuite suite = new TestSuite();
        suite.add(new TestCaseTest("testTemplateMethod"));
        suite.add(new TestCaseTest("testResult"));
        suite.add(new TestCaseTest("testFailedResultFormatting"));
        suite.add(new TestCaseTest("testFailedResult"));
        suite.add(new TestCaseTest("testSuite"));
        // 각 테스트 하나에 객체하나를 만드는게 맞다.
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println(result.getSummary());
    }
}
