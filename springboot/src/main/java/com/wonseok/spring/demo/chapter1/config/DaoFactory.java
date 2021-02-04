package com.wonseok.spring.demo.chapter1.config;

import com.wonseok.spring.demo.chapter1.level5.ConnectionMaker;
import com.wonseok.spring.demo.chapter1.level5.DConnectionMaker;
import com.wonseok.spring.demo.chapter1.level5.UserDaoLevel5;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public UserDaoLevel5 userDaoLevel5(){
        return new UserDaoLevel5(connectionMaker());
    }
    @Bean
    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }
    /*
    @Bean
    public UserDaoLevel5 userDaoLevel5(){
        UserDaoLevel5 userDaoLevel5 = new UserDaoLevel5();
        userDaoLevel5.setConnectionMaker(connectionMaker());
    }
    setter이용하여 DI를 하겠다라는 설정
     */


}
