package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.dao.DaoFactory;
import com.brainacademy.airport.dao.DaoRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gladi on 23.11.2016.
 */
public class FactoryMySql implements DaoFactory {
    private String user = "root";
    private String password = "123456";
    private String url = "jdbc:mysql://localhost:3306/airport?useSSL=false";

    public FactoryMySql() {
    }

    @Override
    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public Map<String, DaoRecord> getDao(Connection connection) {
        Map<String, DaoRecord> mySQLdao = new HashMap<>();
        mySQLdao.put("users", new MySqlUser(connection));
        mySQLdao.put("cities", new MySqlCity(connection));
        mySQLdao.put("classes", new MySqlClassFlight(connection));
        mySQLdao.put("gates", new MySqlGate(connection));
        mySQLdao.put("nationalities", new MySqlNationality(connection));
        mySQLdao.put("statuses", new MySqlStatus(connection));
        mySQLdao.put("terminals", new MySqlTerminal(connection));
        mySQLdao.put("flights", new MySqlFlight(connection));
        mySQLdao.put("passengers", new MySqlPassenger(connection));
        mySQLdao.put("prices", new MySqlPrice(connection));
        mySQLdao.put("tickets", new MySqlTicket(connection));
        return mySQLdao;
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
