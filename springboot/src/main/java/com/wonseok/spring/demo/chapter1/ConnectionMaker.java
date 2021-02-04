package com.wonseok.spring.demo.chapter1;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    public Connection makeConnection()throws ClassNotFoundException, SQLException;
}
