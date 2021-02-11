package com.wonseok.spring.demo.chapter3;

import com.wonseok.spring.demo.chapter1.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;

public class UserDao {

    JdbcContext jdbcContext;

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    /**
     * 템플릿 콜백 패턴 
     * @param user
     */
    public void add(final User user){
        this.jdbcContext.workWithStatementStrategy(c->{
            PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            return ps;
        });
    }

    /**
     * 콜백 재사용을 위한 콜백 분리
     */
    public void deleteAll(){
        this.jdbcContext.executeSql("delete from users");
    }

}
