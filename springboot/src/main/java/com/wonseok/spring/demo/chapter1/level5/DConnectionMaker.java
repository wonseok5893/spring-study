package com.wonseok.spring.demo.chapter1.level5;

import com.wonseok.spring.demo.chapter1.level5.ConnectionMaker;

import java.sql.Connection;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        return null;
    }
}
