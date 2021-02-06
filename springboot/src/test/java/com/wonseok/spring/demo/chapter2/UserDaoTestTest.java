package com.wonseok.spring.demo.chapter2;

import com.wonseok.spring.demo.chapter1.level5.ConnectionMaker;
import com.wonseok.spring.demo.chapter1.level5.DConnectionMaker;
import com.wonseok.spring.demo.chapter1.level5.DaoFactory;
import com.wonseok.spring.demo.chapter1.level5.UserDaoLevel5;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTestTest {
    @Test
    public void addAndGet() throws Exception{
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDaoLevel5 userDaoLevel5 = new UserDaoLevel5(connectionMaker);

        DaoFactory daoFactory = new DaoFactory();
        UserDaoLevel5 userDaoLevel51 = daoFactory.userDao();

//        assertEquals(userDaoLevel5,userDaoLevel51);
        assertNotEquals(userDaoLevel5,userDaoLevel51);
    }

}