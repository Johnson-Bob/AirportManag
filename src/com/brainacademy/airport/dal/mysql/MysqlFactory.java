package com.brainacademy.airport.dal.mysql;

import com.brainacademy.airport.dal.dao.DaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by gladi on 23.11.2016.
 */
public class MysqlFactory implements DaoFactory {
    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }
}
