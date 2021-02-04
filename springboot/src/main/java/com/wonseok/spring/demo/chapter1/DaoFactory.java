package com.wonseok.spring.demo.chapter1;

import com.wonseok.spring.demo.chapter1.User;
import com.wonseok.spring.demo.chapter1.level5.ConnectionMaker;
import com.wonseok.spring.demo.chapter1.level5.DConnectionMaker;
import com.wonseok.spring.demo.chapter1.level5.UserDaoLevel5;

public class DaoFactory {
    public UserDaoLevel5 userDao(){
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDaoLevel5 userDaoLevel5 = new UserDaoLevel5(connectionMaker);
        return userDaoLevel5;
    }
}
