package com.wonseok.spring.demo.chapter3.level1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    @Autowired
    private DataSource dataSource;

    public void deleteAllLevel1() throws SQLException {
        Connection c = dataSource.getConnection();
        PreparedStatement ps = c.prepareStatement("delete from users");
        ps.executeUpdate();

        /** Connection과 PreparedStatement는 보통 풀(poo)방식으로 운영 한다.
         * 제한된 수의 리소스를 만들어 두고 필요할 때 이를 할당하고, 반환하는 방식으로 운영한다.
         * close() -> 리소스 반환 Connection과 PreparedStatement
         */
        ps.close();
        c.close();
    }

    public void deleteAllLevel2()throws SQLException{
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = dataSource.getConnection();
            ps = c.prepareStatement("delete from users");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try{
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(c!=null){
                try{
                    c.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCountLevel2()throws SQLException{
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            c = dataSource.getConnection();
            ps = c.prepareStatement("slelect count(*) from users");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // rs.close() -> ps.close() -> c.close() 만들어진 순서의 반대로 닫는것이 원칙이다.
            if(rs!=null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try{
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(c!=null){
                try{
                    c.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }



}
