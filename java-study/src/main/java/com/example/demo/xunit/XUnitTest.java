package com.example.demo.xunit;

public class XUnitTest {
    public static void main(String[] args) {
        TestSuite suite = TestCase.suite();
        // 각 테스트 하나에 객체하나를 만드는게 맞다.
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println(result.getSummary());

        TestSuite suite2 = new TestSuite();
        suite2.add(new TestCaseTest("testTemplateMethod"));
        suite2.add(suite);
        suite2.add(suite);
        TestResult result2 = new TestResult();
        suite2.run(result2);
        System.out.println(result2.getSummary());
    }
}
