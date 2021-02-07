package com.wonseok.spring.demo.chapter2.exception;

public class NotFoundUserException extends Exception {
    public NotFoundUserException(String id) {
        System.out.println(id+"인 사용자가 없습니다.");
    }
}
