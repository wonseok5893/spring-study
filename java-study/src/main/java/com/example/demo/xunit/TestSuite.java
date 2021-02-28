package com.example.demo.xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {

    List<TestCase> tests = new ArrayList<>();

    public void run(TestResult result) {
        tests.forEach(t->{
            t.run(result);
        });
    }

    public void add(TestCase test) {
        tests.add(test);
    }
}
