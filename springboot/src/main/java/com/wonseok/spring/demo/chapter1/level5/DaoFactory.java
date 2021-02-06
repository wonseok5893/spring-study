package com.wonseok.spring.demo.chapter1.level5;

import com.wonseok.spring.demo.chapter1.level5.*;

public class DaoFactory {
    public UserDaoLevel5 userDao(){
        return new UserDaoLevel5(new DConnectionMaker());

    }
    public AccountDao accountDao(){
        return new AccountDao(new DConnectionMaker());
    }
    public MessageDao messageDao(){
        return new MessageDao(new DConnectionMaker());
    }

    //반복되는 코드를  처리하기 위해
    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }
}
