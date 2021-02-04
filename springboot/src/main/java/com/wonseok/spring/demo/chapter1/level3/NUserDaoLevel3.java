package com.wonseok.spring.demo.chapter1.level3;

import java.sql.Connection;
import java.sql.SQLException;

public class NUserDaoLevel3 extends UserDaoLevel3 {
    public static void main(String[] args) {
        NUserDaoLevel3 nuser = new NUserDaoLevel3();

    }
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // N사 DB connection 생성 코드
        return null;
    }
}
