package com.example.demo.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SuperTypeToken2 {
    static class Sup<T> {
        T value;
    }

    static class Sub extends Sup<String> {
    }

    public static void main(String[] args) {
        Sub b = new Sub();
        Type t = b.getClass().getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType)t;
        System.out.println(ptype.getActualTypeArguments()[0]);
        // eraser로 인해 제너릭 타입이 없어진다고 했는데
        // 어떤건 없어지고 언떤건 안 없어진다.

        // 상속을 할때 generic type을 가지게 된다. reflication 이라고 한다.
    }
}
