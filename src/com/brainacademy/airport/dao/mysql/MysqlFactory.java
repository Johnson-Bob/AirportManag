package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.dao.DaoFactory;
import com.brainacademy.airport.dao.DaoUsers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by gladi on 23.11.2016.
 */
public class MysqlFactory implements DaoFactory {
    private String user = "root";
    private String password = "123456";
    private String url = "jdbc:mysql://localhost:3306/airport?useSSL=false";

    public MysqlFactory() {
    }

    @Override
    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public DaoUsers getDaoUsers(Connection connection) {
        return new MySqlUsers(connection);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
