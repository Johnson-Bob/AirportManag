package com.brainacademy.airport.dal.dao;

import com.brainacademy.airport.model.Cities;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gladi on 23.11.2016.
 */
//** The object for managing the persistent state of the object Cities */
public interface DaoCities {

    /** It creates a new record and the corresponding object */
    public Cities create();

    /** Returns the appropriate record object with primary key */
    public Cities read(int key);

    /** It saves the state of the object group in the database */
    public void update(Cities group);

    /** Removes the entry of the object from the database */
    public void delete(Cities group);

    /** Returns a list of objects corresponding to all of the records in the database */
    public List<Cities> getAll() throws SQLException;
}
