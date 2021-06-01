package com.wonseok.spring.demo.aop;

import com.wonseok.spring.demo.chapter1.User;

import java.util.List;

public interface CacheService {
    String CACHE_GETTING_KEY = "cache:get";

    //카디널리티가 높아야 하나, 이번 예시에서는 이름의 첫글자로 캐싱을 해보겟습니다.
    List<User> getUsers(String startName);
}
