package com.wonseok.spring.demo.chapter2;

import com.wonseok.spring.demo.chapter1.User;
import org.junit.Before;

import static org.junit.Assert.*;

public class UserDaoTest2 {
    private UserDao userDao;
    private User user1;
    private User user2;

    /**
     * @Before 각 테스트마다 새로운 객체 픽스쳐를 만들어 사용
     */
    @Before
    public void setUp(){
        this.user1 = new User("wonseok","최원석","1234");
        this.user2 = new User("junsub","장준섭","1234");
    }



}