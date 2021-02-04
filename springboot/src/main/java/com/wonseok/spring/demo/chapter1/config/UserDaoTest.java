package com.wonseok.spring.demo.chapter1.config;

import com.wonseok.spring.demo.chapter1.level5.ConnectionMaker;
import com.wonseok.spring.demo.chapter1.level5.UserDaoLevel5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDaoLevel5 userDaoLevel5 = context.getBean("userDaoLevel5",UserDaoLevel5.class);
        System.out.println(userDaoLevel5);
        //com.wonseok.spring.demo.chapter1.level5.UserDaoLevel5@27ae2fd0
        //해시값 @27ae2fd0
        ConnectionMaker connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);
        System.out.println(userDaoLevel5.getConnectionMaker()==connectionMaker);
        // 컨테이너에서 주입 받은 connectionMaker 구현체와 컨테이너에서 주입받은 userDao객체를 통해 비교시에 같은것을 확인
        // 즉 컨테이너에서 객체를 생성하고 객체간의 관계를 주입하고 준다.
        // getBean -> Dependency Lookup 이라고 해서 DL이라고 부른다. 빈을 탐색하여 찾아낸다.
    }
}
