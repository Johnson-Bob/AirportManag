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
        mySQLdao.put("users", new MySqlUsers(connection));
        mySQLdao.put("cities", new MySqlCities(connection));
        mySQLdao.put("classes", new MySqlClasses(connection));
        mySQLdao.put("gates", new MySqlGates(connection));
        mySQLdao.put("nationalities", new MySqlNationalities(connection));
        mySQLdao.put("sexes", new MySqlSexes(connection));
        mySQLdao.put("statuses", new MySqlStatuses(connection));
        mySQLdao.put("terminals", new MySqlTerminals(connection));
        mySQLdao.put("flights", new MySqlFlights(connection));
        mySQLdao.put("passengers", new MySqlPassengers(connection));
        mySQLdao.put("prices", new MySqlPrices(connection));
        mySQLdao.put("tickets", new MySqlTickets(connection));
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
