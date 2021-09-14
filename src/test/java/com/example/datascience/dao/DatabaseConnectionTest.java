package com.example.datascience.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
public class DatabaseConnectionTest {

    @Resource
    DataSource datasource;

    @Test
    public void testConnection() throws SQLException {
        datasource.getConnection();
    }
}
