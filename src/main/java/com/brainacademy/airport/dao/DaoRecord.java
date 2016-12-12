package com.brainacademy.airport.dao;

import com.brainacademy.airport.entity.Entity;

import java.util.List;

/**
 * Created by gladi on 23.11.2016.
 */
//** The object for managing the persistent state of the object Users */
public interface DaoRecord<T extends Entity> {
    /** It creates a new record and the corresponding object */
    public void create(T record) throws PersistException;

    /** Returns the appropriate record object with primary key */
    public T read(int id) throws PersistException;

    /** It saves the state of the object group in the database */
    public void update(T record) throws PersistException;

    /** Removes the entry of the object from the database */
    public void delete(T record) throws PersistException;

    /** Returns a list of objects corresponding to all of the records in the database */
    public List<T> getAll() throws PersistException;

    /**Returns a list of objects corresponding to records in the query*/
    public List<T> select(String where) throws PersistException;
}
