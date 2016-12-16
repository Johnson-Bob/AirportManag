package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.dao.DaoRecord;
import com.brainacademy.airport.dao.PersistException;
import com.brainacademy.airport.entity.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gladi on 24.11.2016.
 */
public abstract class MySqlRecord<T extends Entity> implements DaoRecord<T> {
    private Connection connection;
    protected String selectQuery;
    protected String selectLastInsert;
    protected String readQuery;
    protected String createQuery;
    protected String updateQuery;
    protected String deleteQuery;

    public MySqlRecord() {
    }

    public MySqlRecord(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(T entity) throws PersistException {
        if (entity.getId() != 0){
            throw new PersistException("Object is already persist.");
        }

        //Insert record
        try(PreparedStatement pstm = connection.prepareStatement(createQuery)) {
            setPreparedStatement(pstm, entity, false);
            int count = pstm.executeUpdate();
            if (count != 1){
                throw new PersistException("On persist modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }

//        Get just inserting records and set userId
        List<T> newEntity = select(selectLastInsert);
        if (newEntity == null || newEntity.size() != 1){
            throw new PersistException("Received more than one record: " + newEntity.size());
        }else {
            entity.setId(newEntity.get(0).getId());
        }
    }

    @Override
    public T read(int id) throws PersistException {
        List<T> selectEntity = null;
        try (PreparedStatement pstm = connection.prepareStatement(readQuery)){
            pstm.setInt(1, id);
            selectEntity = parseResultSet(pstm.executeQuery());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        if (selectEntity == null || selectEntity.size() == 0){
            throw new PersistException("Record with `user_id` = " + id + " not found.");
        }
        if (selectEntity.size() > 1){
            throw new PersistException("Received more than one record: " + selectEntity.size());
        }
        return selectEntity.iterator().next();
    }

    @Override
    public void update(T entity) throws PersistException {
        try (PreparedStatement pstm = connection.prepareStatement(updateQuery)){
            setPreparedStatement(pstm, entity, true);
            int count = pstm.executeUpdate();
            if (count != 1){
                throw new PersistException("On update modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public void delete(T entity) throws PersistException {
        try (PreparedStatement pstm = connection.prepareStatement(deleteQuery)){
            pstm.setInt(1, entity.getId());
            int count = pstm.executeUpdate();
            if (count != 1){
                throw new PersistException("On delete modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public List<T> getAll() throws PersistException {
        return select(";");
    }

    @Override
    public List<T> select(String where) throws PersistException {
        String sql = selectQuery + where;
        List<T> selectEntities = null;
        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            selectEntities = parseResultSet(pstm.executeQuery());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return selectEntities;
    }



    //Set parametrs of PreparedStatement
    protected abstract void setPreparedStatement(PreparedStatement ps, T entity, boolean where) throws SQLException;

    //Returns a list of objects from Result Set
    protected abstract List<T> parseResultSet(ResultSet rs) throws SQLException, PersistException;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
