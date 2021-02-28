package com.example.demo.xunit;

public class XUnitTest {
    public static void main(String[] args) {
        TestSuite suite = TestCaseTest.suite();
        // 각 테스트 하나에 객체하나를 만드는게 맞다.
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println(result.getSummary());

    }
}
