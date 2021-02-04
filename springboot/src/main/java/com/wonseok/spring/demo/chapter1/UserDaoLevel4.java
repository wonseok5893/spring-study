package com.wonseok.spring.demo.chapter1;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoLevel4 {
    private SimpleConnectionMaker simpleConnectionMaker;

    public UserDaoLevel4(SimpleConnectionMaker simpleConnectionMaker) {
        this.simpleConnectionMaker = simpleConnectionMaker;
    }
    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection c = simpleConnectionMaker.makeNewConnection();
        //..
    }
    public User get(String id) throws SQLException, ClassNotFoundException {
        Connection c = simpleConnectionMaker.makeNewConnection();
        //..
        return new User();
    }
}
