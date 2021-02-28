package com.example.demo.xunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSuite implements Test {

    List<Test> tests = new ArrayList<>();

    public TestSuite() {
    }

    public TestSuite(Class<? extends Test> testClass) {
        Arrays.stream(testClass.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("test"))
                .forEach(m -> {
                            try {
                                add(testClass.getConstructor(String.class).newInstance(m.getName()));
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
    }

    public void run(TestResult result) {
        tests.forEach(t -> {
            t.run(result);
        });
    }

    public void add(Test test) {
        tests.add(test);
    }
}
