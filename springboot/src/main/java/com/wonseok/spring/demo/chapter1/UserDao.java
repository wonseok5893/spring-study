package com.wonseok.spring.demo.chapter1;

import com.wonseok.spring.demo.chapter1.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(User user) throws SQLException {
        Connection c = dataSource.getConnection();
    }
}
