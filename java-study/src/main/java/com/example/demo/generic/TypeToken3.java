package com.example.demo.generic;

public class TypeToken3 {
    <T> T create(Class<T> clazz) throws Exception {
        return clazz.newInstance();
    }
    // 캐스팅이 필요없음
    // type safe 하다

    public static void main(String[] args) {
        Object o = "String";
        Integer i = (Integer) o;
        //강제 캐스팅 하면 컴파일이 되어버린다.
        //런타임시 ClassCastException 발생
        System.out.println(i);

    }
}
