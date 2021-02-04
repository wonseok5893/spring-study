package com.wonseok.spring.demo.chapter1;

public class UserDaoTest {
    public static void main(String[] args) {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDaoLevel5 userDaoLevel5 = new UserDaoLevel5(connectionMaker);
        // 제 3자가 주입을 해줬다
        // userdao가 관계를 설정하는 책임을 UserDaoTest가 런타임시에 해결해줬다.
    }
}
