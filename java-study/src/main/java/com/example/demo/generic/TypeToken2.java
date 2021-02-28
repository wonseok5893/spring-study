package com.example.demo.generic;

public class TypeToken2 {
    static class Generic<T> {
        T value;
        void set(T t){ value = t;}

        T get(){
            return null;}
    }
    public static void main(String[] args) {
        Generic<String> s = new Generic<>();
        s.value = "String";
        // type erasure에 의해서 런타임시 type이 삭제
        // Object로서 동작한다
        // (String) 컴파일러가 casting을 해준다.

        Generic<Integer> i = new Generic<>();
        i.value = 1;
        i.set(10);

    }
}
