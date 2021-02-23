package com.wonseok.spring.demo.jdbcTemplate;

import com.wonseok.spring.demo.chapter1.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class UserDaoJdbcTemplateTest {

    @Autowired
    DataSource dataSource;
    UserDao userDao = new UserDao();

    @Test
    public void add(){
        userDao.setDataSource(dataSource);

        int before = userDao.getCount();

        User user = new User();
        user.setId("won");
        user.setName("seok");
        user.setPassword("1234");

        userDao.add(user);

        int after = userDao.getCount();
        assertEquals(before+1,after);


    }
    @Test
    public void getAll(){
        List<User> all = userDao.getAll();
        assertEquals(all.size(),2);
    }
}