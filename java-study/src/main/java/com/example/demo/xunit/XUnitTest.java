package com.example.demo.xunit;

public class XUnitTest {
    public static void main(String[] args) {
        TestResult result = new TestResult();
        new TestCaseTest("testTemplateMethod").run(result);
        // 각 테스트 하나에 객체하나를 만드는게 맞다.
        new TestCaseTest("testResult").run(result);
        new TestCaseTest("testFailedResultFormatting").run(result);
        new TestCaseTest("testFailedResult").run(result);
        new TestCaseTest("testSuite").run(result);
        System.out.println(result.getSummary());
    }
}
