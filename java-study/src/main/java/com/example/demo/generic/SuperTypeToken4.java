package com.example.demo.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class SuperTypeToken4 {
    static class Sup<T>{
        T value;
    }
    public static void main(String[] args) {
        Type t = (new Sup<List<String>>() {
        }).getClass().getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType) t;
        System.out.println(ptype.getActualTypeArguments()[0]);
    }
}
