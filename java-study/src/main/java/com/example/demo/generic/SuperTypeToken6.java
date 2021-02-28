package com.example.demo.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class SuperTypeToken6 {
    static class TypesafeMap {
        Map<TypeReference<?>, Object> map = new HashMap<>();

        <T> void put(TypeReference<T> tr, T value) {
            map.put(tr, value);
        }

        <T> T get(TypeReference<T> tr) {
            if (tr.type instanceof Class<?>)
                return ((Class<T>) tr.type).cast(map.get(tr));
            // TypeReference<String>
            else
                return ((Class<T>) ((ParameterizedType) tr.type).getRawType()).cast(map.get(tr));
            // TypeReference<List<String>>
        }
    }

    static class TypeReference<T> {
        Type type;

        public TypeReference() {
            Type stype = getClass().getGenericSuperclass();
            if (stype instanceof ParameterizedType) {
                this.type = ((ParameterizedType) stype).getActualTypeArguments()[0];
            } else throw new RuntimeException();
        }

        // hashcode로 비교하고 같으면 equals를 비교한다.
        // hashcode가 더 빠르니까

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass().getSuperclass() != o.getClass().getSuperclass()) return false;
            TypeReference<?> that = (TypeReference<?>) o;
            return Objects.equals(type, that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type);
        }
    }


    public static void main(String[] args) {
        TypesafeMap m = new TypesafeMap();
        m.put(new TypeReference<Integer>() {
        }, 1);
        m.put(new TypeReference<String>() {
        }, "123");
        m.put(new TypeReference<List<String>>() {
        }, Arrays.asList("a", "b", "c"));
        m.put(new TypeReference<List<Integer>>() {
        }, Arrays.asList(1, 2, 3));

        System.out.println(m.get(new TypeReference<String>() {
        }));
        System.out.println(m.get(new TypeReference<Integer>() {
        }));
        System.out.println(m.get(new TypeReference<List<String>>() {
        }));
        System.out.println(m.get(new TypeReference<List<Integer>>() {
        }));
    }
}
