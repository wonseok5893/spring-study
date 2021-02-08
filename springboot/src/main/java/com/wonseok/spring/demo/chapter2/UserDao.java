package com.wonseok.spring.demo.chapter2;

import com.wonseok.spring.demo.chapter1.User;
import com.wonseok.spring.demo.chapter2.exception.NotFoundUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDao {

    private DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(User user) throws SQLException {
        Connection c = dataSource.getConnection();
        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws SQLException, NotFoundUserException {

        Connection c = dataSource.getConnection();
        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        User user = null;
        ResultSet rs = ps.executeQuery();
        rs.last();
        if (rs.getRow() == 0) throw new NotFoundUserException(id);

        // row 0
        rs.beforeFirst();
        // -> rs.first() row 1 이라서 위와 같이 작성
        rs.next();
        // row++

        user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public void deleteAll() throws SQLException {
        Connection c = dataSource.getConnection();
        PreparedStatement ps = c.prepareStatement("delete from users where 1 = 1");

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public int getCount() throws SQLException {
        ResultSet rs = dataSource.getConnection().prepareStatement("select count(*) from users").executeQuery();
        rs.next();
        int count = rs.getInt(1);

        rs.close();
        // 다음과 같이 Connection 과 PreparStatement 를 닫아줄수 없어 메모리 Leak이 발생할 수 있다.
        return count;
    }
}
