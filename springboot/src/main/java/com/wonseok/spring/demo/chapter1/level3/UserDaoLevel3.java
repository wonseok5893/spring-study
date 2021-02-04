package com.wonseok.spring.demo.chapter1.level3;

import com.wonseok.spring.demo.chapter1.User;

import java.sql.*;

public abstract class UserDaoLevel3 {
    public void add(User user)throws ClassNotFoundException, SQLException {
        // getConnection을 서버클래스에서 오버라이드 하여 슈퍼클래스의 로직에 맞게 사용
        // -> 템플릿 메소드 패턴
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }
    public User get(String id)throws ClassNotFoundException, SQLException{
        // getConnection을 서버클래스에서 오버라이드 하여 슈퍼클래스의 로직에 맞게 사용
        // -> 템플릿 메소드 패턴
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        rs.close();
        ps.close();
        c.close();
        return user;
    }

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}
