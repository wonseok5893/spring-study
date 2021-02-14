package com.wonseok.spring.demo.chapter3;

import com.wonseok.spring.demo.chapter1.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoFinalTest {

    @Test
    void add() {
        UserDaoFinal userDao = new UserDaoFinal();
        User user = new User("won1","최원석","1234");
        userDao.add(user);

    }
}