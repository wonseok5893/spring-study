package com.wonseok.spring.demo.chapter3.templateCallback;

import com.wonseok.spring.demo.chapter3.templateCallback.level1.CalculatorLevel1;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void sumOfNumbers() throws IOException {
        CalculatorLevel1 calculator = new CalculatorLevel1();

        int sum = calculator.calcSum(getClass().getResource("/numbers.txt").getPath());

        assertEquals(sum,10);

    }
}