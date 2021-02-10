package com.wonseok.spring.demo.chapter3.level5;

import com.wonseok.spring.demo.chapter1.User;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoChapter3Level5Test {

    @Autowired
    DataSource dataSource;

    @Test
    public void deleteAll() {
        UserDao userDao = new UserDao(dataSource);
        userDao.jdbcContextWithStatementStrategy((c)->c.prepareStatement("delete from users"));
    }

    @Test void add() throws SQLException {
        com.wonseok.spring.demo.chapter2.UserDao userDao = new com.wonseok.spring.demo.chapter2.UserDao(dataSource);
        userDao.add(new User("wonseok1234","최원석","1234"));
    }

}