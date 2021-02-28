package com.example.demo.xunit;

import org.springframework.core.annotation.AnnotationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSuite implements Test {

    List<Test> tests = new ArrayList<>();

    public TestSuite() {
    }

    //refection method 이름 앞에 test / 생성자 파라미터로 String을 하나 받는 클래스 객체를 생성하여 add 해준다
//    public TestSuite(Class<? extends Test> testClass) {
//        Arrays.stream(testClass.getDeclaredMethods())
//                .filter(m -> m.getName().startsWith("test"))
//                .forEach(m -> {
//                            try {
//                                add(testClass.getConstructor(String.class).newInstance(m.getName()));
//                            } catch (Exception e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//                );
//    }

    public TestSuite(Class<? extends Test> testClass) {
        Arrays.stream(testClass.getDeclaredMethods())
                .filter(m -> AnnotationUtils.findAnnotation(m, com.example.demo.xunit.annotation.Test.class)!=null)
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
