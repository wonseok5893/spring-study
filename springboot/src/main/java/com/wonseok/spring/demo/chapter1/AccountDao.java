package com.wonseok.spring.demo.chapter1;

import com.wonseok.spring.demo.chapter1.level5.ConnectionMaker;

public class AccountDao {
    private ConnectionMaker connectionMaker;

    public AccountDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
}
