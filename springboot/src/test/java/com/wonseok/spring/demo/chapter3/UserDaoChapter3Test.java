package com.wonseok.spring.demo.chapter3;

import com.wonseok.spring.demo.chapter1.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoChapter3Test {

    @Autowired
    JdbcContext jdbcContext;

    @Test
    void add() {
        UserDao userDao = new UserDao();
        userDao.setJdbcContext(jdbcContext);
        userDao.add(new User("wonseok", "최원석", "1234"));
    }
}