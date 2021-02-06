package com.wonseok.spring.demo.chapter1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class BeanConfig {
    @Bean
    public UserDao userDao(){
        return new UserDao(dataSource());
    }

    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//        dataSource.setDriverClass();
//        dataSource.setUrl();
//        dataSource.setUsername();
//        dataSource.setPassword();
        return dataSource;
    }


}
