package com.wonseok.spring.demo.chapter3.templateCallback.level1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalculatorLevel1 {

    public Integer calcSum(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        Integer sum = 0;
        String line = null;
        while((line = br.readLine())!=null){
            sum += Integer.valueOf(line);
        }
        br.close();
        return sum;
    }
}
