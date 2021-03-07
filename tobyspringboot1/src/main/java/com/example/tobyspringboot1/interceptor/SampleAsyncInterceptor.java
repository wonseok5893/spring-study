package com.example.tobyspringboot1.interceptor;

import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleAsyncInterceptor implements AsyncHandlerInterceptor {
    // AsyncHandlerInterceptor -> HandlerInterceptor
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //servlet3.0 부터 비동기 지원이 가능해져서, 비동기 사용시 postHandler()와 afterCompletion()을 사용할수 없기 때문에 이 메소드를 사용.
    }

}
