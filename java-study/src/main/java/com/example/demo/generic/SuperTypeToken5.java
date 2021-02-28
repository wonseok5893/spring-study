package com.example.demo.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class SuperTypeToken5 {
    static class TypesafeMap{
        Map<Class<?>, Object> map = new HashMap<>();

        <T> void put(Class<T> clazz, T value) {
            map.put(clazz, value);
        }

        <T> T get(Class<T> clazz) {
            return clazz.cast(map.get(clazz));
        }
    }

    static class TypeReference<T> {
        Type type;

        public TypeReference() {
            Type stype = getClass().getGenericSuperclass();
            if (stype instanceof ParameterizedType) {
                this.type = ((ParameterizedType)stype).getActualTypeArguments()[0];
            } else throw new RuntimeException();
        }
    }


    public static void main(String[] args) {
//        TypeReference t = new TypeReference<String>();
//        System.out.println(t.type);
        // RuntimeException 발생
        TypeReference t = new TypeReference<String>(){};
        System.out.println(t.type);

    }
}
