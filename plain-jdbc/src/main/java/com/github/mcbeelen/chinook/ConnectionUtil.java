package com.github.mcbeelen.chinook;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public enum ConnectionUtil {

    INSTANCE;

    public final DataSource dataSource;
    ConnectionUtil() {
        Properties configProperties = new Properties();

        configProperties.setProperty("jdbcUrl", "jdbc:mysql://remotemysql.com:3306/OJpwdfrCqW");
        configProperties.setProperty("username", "OJpwdfrCqW");
        configProperties.setProperty("password", "Hzbt4PVTZY");
        configProperties.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
        configProperties.setProperty("minimumIdle", "2");

        dataSource = new HikariDataSource(new HikariConfig(configProperties));
    }
}
