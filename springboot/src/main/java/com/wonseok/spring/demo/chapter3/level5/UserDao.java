package com.wonseok.spring.demo.chapter3.level5;

import com.wonseok.spring.demo.chapter3.level3.StatementStrategy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 익명 클래스를 이용해서 다음과 같이 사용
     * 람다를 이용하여 사용
     */
    public void deleteAll(){
        jdbcContextWithStatementStrategy(new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                return c.prepareStatement("delete from users");
            }
        });
    }
    public void deleteAllLevel2(){
        jdbcContextWithStatementStrategy((Connection c)->c.prepareStatement("delete from users"));
    }
    public void jdbcContextWithStatementStrategy(StatementStrategy strategy) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = dataSource.getConnection();

            ps = strategy.makePreparedStatement(c);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
