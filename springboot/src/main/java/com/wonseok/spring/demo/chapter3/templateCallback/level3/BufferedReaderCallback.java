package com.wonseok.spring.demo.chapter3.templateCallback.level3;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderCallback {
    Integer doSomethingWithReader(BufferedReader br) throws IOException;

    default Integer doSomething(String line, int sum) {
        return null;
    }
}
