package com.wonseok.spring.demo.chapter3;

import com.wonseok.spring.demo.chapter1.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoFinal {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void deleteAll() {
        this.jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                return con.prepareStatement("delete from users");
            }
        });
    }

    public void deleteAllExecuteSql() {
        this.jdbcTemplate.execute("delete from users");

    }
    public void add(User user){
        this.jdbcTemplate.update("insert into users(id, name, password) values(?,?,?)",user.getId(),user.getName(),user.getPassword());
    }
}
