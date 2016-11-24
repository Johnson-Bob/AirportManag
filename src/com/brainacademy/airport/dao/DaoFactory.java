package com.brainacademy.airport.dao;

import com.brainacademy.airport.dao.mysql.MySqlUsers;
import com.brainacademy.airport.model.Cities;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by gladi on 23.11.2016.
 */
public interface DaoFactory {

    Connection getConnection() throws SQLException;

    DaoUsers getDaoUsers(Connection connection);

    //TODO: methods for create objects for managing the persistent state of the models
}
