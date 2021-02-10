package com.wonseok.spring.demo.chapter3.level3;

import com.wonseok.spring.demo.chapter3.level2.AbstractUserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao{

    DataSource dataSource;

    public void deleteAll(){
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = dataSource.getConnection();
            /**
             * 전략 패턴으로 구현
             */
            StatementStrategy statementStrategy = new DeleteAllStatement();
            ps = statementStrategy.makePreparedStatement(c);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(c!=null){
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
