package com.wonseok.spring.demo.chapter3;

import com.wonseok.spring.demo.chapter1.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;

public class UserDao {

    JdbcContext jdbcContext;

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public void add(final User user){
        this.jdbcContext.workWithStatementStrategy(c->{
            PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            return ps;
        });
    }

    public void deleteAll(){
        this.jdbcContext.executeSql("delete from users");
    }

}
