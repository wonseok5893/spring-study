package com.wonseok.spring.demo.chapter2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class UserDaoTest3 {
    @Autowired
    private ApplicationContext applicationContext;

    private UserDao userDao;

    @Before
    public void setUp(){
        this.userDao = this.applicationContext.getBean("userDao",UserDao.class);
    }
    @Test
    public void test1(){
        System.out.println("테스트");
    }
}
