package com.wonseok.spring.demo.chapter3.templateCallback;

public interface LineCallback<T> {

    T doSomething(String line, T value );
}
