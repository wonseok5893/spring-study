package com.wonseok.spring.demo.chapter3.templateCallback.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorLevel3Test {

    CalculatorLevel3 calculator = new CalculatorLevel3();

    @Test
    void addTest() throws IOException {
        int res = calculator.calcSum(getClass().getResource("/numbers.txt").getPath());

        assertEquals(res,10);
    }

    @Test
    void multiplyTest() throws IOException {
        int res = calculator.calcMultiply(getClass().getResource("/numbers.txt").getPath());

        assertEquals(res,24);
    }
}