package com.wonseok.spring.demo.chapter1.level5;

public class UserDaoLevel5 {
    private ConnectionMaker connectionMaker;

    public UserDaoLevel5(ConnectionMaker connectionMaker) {
        // UserDao가 ConnectionMaker를 결정해야한다? -> 결합도가 제거 되지 않았다. -> 제 3자한테 맡기면 해결되지 않을까?
        //this.connectionMaker = new DConnectionMaker();
        this.connectionMaker = connectionMaker;
    }

    public ConnectionMaker getConnectionMaker() {
        return connectionMaker;
    }
}
