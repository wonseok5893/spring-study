package com.wonseok.spring.demo.chapter3.level2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao extends AbstractUserDao {
    @Override
    public PreparedStatement makeStatement(Connection c) throws SQLException {
         return c.prepareStatement("delete from users");
    }
}
