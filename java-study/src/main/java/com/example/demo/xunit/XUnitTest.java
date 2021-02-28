package com.example.demo.xunit;

public class XUnitTest {
    public static void main(String[] args) {
        new TestCaseTest("testTemplateMethod").run();
        // 각 테스트 하나에 객체하나를 만드는게 맞다.
        new TestCaseTest("testResult").run();
    }
}
