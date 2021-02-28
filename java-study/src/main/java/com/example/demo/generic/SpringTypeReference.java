package com.example.demo.generic;

import org.springframework.core.ParameterizedTypeReference;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpringTypeReference {
    public static void main(String[] args) {
        ParameterizedTypeReference type = new ParameterizedTypeReference<List<Map<Set<Integer>, String>>>() {
        };
        System.out.println(type.getType());
        // spring 3.2 이상
    }
    // 스프링에서는 이미 구현이 되있으니 가져다가 사용해라
}
