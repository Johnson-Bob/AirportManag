package com.brainacademy.airport.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gladi on 23.11.2016.
 */
public interface DaoFactory {

    Connection getConnection() throws SQLException;

    List<DaoRecords> getDao(Connection connection);

    //TODO: methods for create objects for managing the persistent state of the models
}
