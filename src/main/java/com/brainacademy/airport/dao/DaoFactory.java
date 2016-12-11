package com.brainacademy.airport.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by gladi on 23.11.2016.
 */
public interface DaoFactory {

    Connection getConnection() throws SQLException;

    Map<String, DaoRecord> getDao(Connection connection);
}
