package com.example.demo.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class SuperTypeToken3 {
    static class Sup<T>{
        T value;
    }
    public static void main(String[] args) {
        // Local Class 메소드영역에서만 쓸 수 있는 클래스
        class Sub extends Sup<List<String>>{

        }
        Sub b = new Sub();
        Type t = b.getClass().getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType)t;
        System.out.println(ptype.getActualTypeArguments()[0]);
    }
}
