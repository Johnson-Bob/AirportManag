package com.brainacademy.airport.dao;

import com.brainacademy.airport.model.Cities;
import com.brainacademy.airport.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gladi on 23.11.2016.
 */
//** The object for managing the persistent state of the object Users */
public interface DaoUsers {

    /** It creates a new record and the corresponding object */
    public void create(Users user) throws PersistException;

    /** Returns the appropriate record object with primary key */
    public Users read(Integer id) throws PersistException;

    /** It saves the state of the object group in the database */
    public void update(Users user) throws PersistException;

    /** Removes the entry of the object from the database */
    public void delete(Users user) throws PersistException;

    /** Returns a list of objects corresponding to all of the records in the database */
    public List<Users> getAll() throws PersistException;

    /**Returns a list of objects corresponding to records in the query*/
    public List<Users> select(String where) throws PersistException;

    /**Returns a list of objects from Result Set*/
    public List<Users> parseResultSet(ResultSet rs) throws SQLException;

    /**Set parametrs of PreparedStatement*/
    public void setPreparedStatement(PreparedStatement ps, Users user) throws SQLException;
}
