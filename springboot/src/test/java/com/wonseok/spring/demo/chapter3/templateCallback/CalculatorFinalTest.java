package com.wonseok.spring.demo.chapter3.templateCallback;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorFinalTest {

    Calculator calculator = new Calculator();

    @Test
    void 덧셈() throws IOException {
        int res = calculator.template(getClass().getResource("/numbers.txt").getPath(), (String line, Integer e) -> e + Integer.parseInt(line), 1);
        assertEquals(res,11);
    }

    @Test
    void 문자이어붙이기() throws IOException {
        String res = calculator.template(getClass().getResource("/numbers.txt").getPath(),(line,e)->e+line,"");
        assertEquals(res,"1234");
    }
}