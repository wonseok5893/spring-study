package com.example.demo.generic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeToken6 {
    static class TypesafeMap{
        Map<Class<?>, Object> map = new HashMap<>();

        <T> void put(Class<T> clazz, T value) {
            map.put(clazz, value);
        }

        <T> T get(Class<T> clazz) {
            return clazz.cast(map.get(clazz));
        }
    }

    public static void main(String[] args) {
        TypeToken5.TypesafeMap m = new TypeToken5.TypesafeMap();
        m.put(String.class, "Value");
//        m.put(List<Integer>.class, Arrays.asList(1, 2, 3)); // List<Integer>
//        m.put(List<String>.class, Arrays.asList("a", "b", "c")); // List<String>
        // 에러 발생
        // Class타입에는 generic 정보가 없다.
        // 제너릭 정보까지 Type Token 불가능
        // => Super Type Token 으로 해결
        System.out.println(m.get(List.class));

    }
}
