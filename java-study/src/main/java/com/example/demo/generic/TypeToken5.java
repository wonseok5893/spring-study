package com.example.demo.generic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeToken5 {
    static class TypesafeMap{
        Map<Class<?>, Object> map = new HashMap<>();

        <T> void put(Class<T> clazz, T value) {
            map.put(clazz, value);
        }

        <T> T get(Class<T> clazz) {
            return clazz.cast(map.get(clazz));
            // (T) map.get(clazz)
            // 강제 type casting 위험
            // clazz.cast(map.get(clazz))
            // type safe
        }
    }

    /// 특정 타입의 클래스 정보를 넘겨서 Type safe하게 만드는 기술
    // -> Type Token이라 한다.

   public static void main(String[] args) {
        TypesafeMap m = new TypesafeMap();
        m.put(String.class, "Value");
//        m.put(Integer.class, "class");
        // Integer key에 String value가 들어간다. -> type 일치 시켜야한다.
        m.put(List.class, Arrays.asList(1, 2, 3));

        System.out.println(m.get(String.class));
        System.out.println(m.get(List.class));
    }
}
