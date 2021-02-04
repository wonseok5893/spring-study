package com.wonseok.spring.demo.chapter1;

import com.wonseok.spring.demo.chapter1.level5.ConnectionMaker;
import com.wonseok.spring.demo.chapter1.level5.DConnectionMaker;

public class MessageDao {
    ConnectionMaker connectionMaker;
    public MessageDao(ConnectionMaker connectionMaker) {
        connectionMaker = connectionMaker;
    }
}
