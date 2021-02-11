package com.wonseok.spring.demo.chapter3.templateCallback.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorLevel3Test {

    @Test
    void fileReadTemplate() throws IOException {
        CalculatorLevel3 calculator = new CalculatorLevel3();
        int res = calculator.calcSum(getClass().getResource("/numbers.txt").getPath());

        assertEquals(res,10);
    }
}