package com.brainacademy.airport.dal.dao;

import com.brainacademy.airport.model.Cities;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by gladi on 23.11.2016.
 */
public interface DaoFactory {
    Connection getConnection() throws SQLException;

    //TODO: methods for create objects for managing the persistent state of the models
}
