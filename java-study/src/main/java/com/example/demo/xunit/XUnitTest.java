package com.example.demo.xunit;

public class XUnitTest {
    public static void main(String[] args) {
        System.out.println(new TestCaseTest("testTemplateMethod").run().getSummary());
        // 각 테스트 하나에 객체하나를 만드는게 맞다.
        new TestCaseTest("testResult").run();
        new TestCaseTest("testFailedResultFormatting").run();
        new TestCaseTest("testFailedResult").run();
    }
}
