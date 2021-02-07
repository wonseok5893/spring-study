package com.wonseok.spring.demo.chapter2;

import com.wonseok.spring.demo.chapter1.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;


import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class UserDaoTestTest {

    @Autowired
    private UserDao userDao;

    @BeforeEach
    public void before() throws SQLException {
        userDao.deleteAll();
    }

    @Test
    public void add() throws Exception{
        User user = new User();
        user.setId("wonseok");
        user.setName("최원석");
        user.setPassword("1234");
        userDao.add(user);
    }

    @Test void addAndGet() throws SQLException {
        User user = new User();
        user.setId("wonseok2");
        user.setName("최원석");
        user.setPassword("1234");
        userDao.add(user);

        User user1 = userDao.get(user.getId());
        assertEquals(user.getId(),user1.getId());
    }

    @Test void deleteAll() throws SQLException {
        userDao.deleteAll();
    }
    @Test void getCount() throws SQLException {
        int count = userDao.getCount();

        User user = new User("wonseok","최원석","1234");
        userDao.add(user);

        int count1 = userDao.getCount();

        assertEquals(count+1,count1);
    }

    @Test()
    void 없는_사용자_아이디_조회() throws SQLException {
        assertThrows(Exception.class,()->{
            userDao.get("unknown_id");
        });

    }
}