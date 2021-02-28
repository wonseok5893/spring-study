package com.example.demo.generic;

import com.example.demo.DemoApplication.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class SpringTypeReferenceTest {
    public static void main(String[] args) {
        RestTemplate rt = new RestTemplate();
//        List<Map> users = rt.getForObject("http://localhost:8080", List.class);
//        System.out.println(users.get(0).get("name"));

        // 단일 오브젝트일때는 유용하게 사용

        List<User> users = rt.exchange("http://localhost:8080", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        }).getBody();
        // low level 인 exchange를 사용하여 ParameterizedTypeReference 사용하면된다.
        users.forEach(System.out::println);
    }
}
