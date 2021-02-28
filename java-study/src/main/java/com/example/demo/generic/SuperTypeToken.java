package com.example.demo.generic;

public class SuperTypeToken {

    static class Sup<T>{
        T value;
    }
    public static void main(String[] args) throws NoSuchFieldException {
        Sup<String> s = new Sup<>();
        //
        System.out.println(s.getClass().getDeclaredField("value").getType());
        // class java.lang.Object 라고 출력
        // 리플렉션을 통해서도 타입을 알 수 없다
    }
}
