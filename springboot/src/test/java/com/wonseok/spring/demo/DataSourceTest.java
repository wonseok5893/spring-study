package com.wonseok.spring.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.sql.DataSource;
import java.sql.SQLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class DataSourceTest {

    @Autowired
    DataSource dataSource;

    @Test
    void checkDataSource() throws SQLException {
        System.out.println(dataSource.getClass().getName());
//        Assertions.assertEquals(dataSource.getClass().getName());
    }
}
