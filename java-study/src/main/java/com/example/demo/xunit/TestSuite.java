package com.example.demo.xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {

    List<WasRun> tests = new ArrayList<>();

    public void run(TestResult result) {
        tests.forEach(t->{
            t.run(result);
        });
    }

    public void add(WasRun test) {
        tests.add(test);
    }
}
