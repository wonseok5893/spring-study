package com.wonseok.spring.demo.chapter3.templateCallback.level4;

import com.wonseok.spring.demo.chapter3.templateCallback.level3.BufferedReaderCallback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculatorlevel4 {

    public Integer templateMethod(String filePath, BufferedReaderCallback callback, int initValue) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));

            Integer sum = initValue;
            String line = null;
            while ((line = br.readLine()) != null) {
                sum = callback.doSomething(line,sum);
            }
            return sum;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}
