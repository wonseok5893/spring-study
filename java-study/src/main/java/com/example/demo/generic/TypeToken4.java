package com.example.demo.generic;

import java.util.HashMap;
import java.util.Map;

public class TypeToken4 {
    static class TypeSafeMap {
        Map<String, Object> map = new HashMap<>();

        void run() {
            map.put("a", "a");
            map.put("b", 1);
            Integer i = (Integer) map.get("a");
            String s = String.valueOf(map.get("b"));
            // 이런 코드는 위험하다.
            // 굳이 이렇게 사용하지 마라        }
        }
    }
    public static void main(String[] args) {
        System.out.println("");
    }
}
