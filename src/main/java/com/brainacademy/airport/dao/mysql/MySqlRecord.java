package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.dao.DaoRecord;
import com.brainacademy.airport.dao.PersistException;
import com.brainacademy.airport.model.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gladi on 24.11.2016.
 */
public abstract class MySqlRecord implements DaoRecord {
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
    public void create(Model model) throws PersistException {
        if (model.getId() != 0){
            throw new PersistException("Object is already persist.");
        }

        //Insert record
        try(PreparedStatement pstm = connection.prepareStatement(createQuery)) {
            setPreparedStatement(pstm, model, false);
            int count = pstm.executeUpdate();
            if (count != 1){
                throw new PersistException("On persist modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }

//        Get just inserting records and set userId
        List<Model> newModel = select(selectLastInsert);
        if (newModel == null || newModel.size() != 1){
            throw new PersistException("Received more than one record: " + newModel.size());
        }else {
            model.setId(newModel.get(0).getId());
        }
    }

    @Override
    public Model read(int id) throws PersistException {
        List<Model> selectModel = null;
        try (PreparedStatement pstm = connection.prepareStatement(readQuery)){
            pstm.setInt(1, id);
            selectModel = parseResultSet(pstm.executeQuery());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        if (selectModel == null || selectModel.size() == 0){
            throw new PersistException("Record with `user_id` = " + id + " not found.");
        }
        if (selectModel.size() > 1){
            throw new PersistException("Received more than one record: " + selectModel.size());
        }
        return selectModel.iterator().next();
    }

    @Override
    public void update(Model model) throws PersistException {
        try (PreparedStatement pstm = connection.prepareStatement(updateQuery)){
            setPreparedStatement(pstm, model, true);
            int count = pstm.executeUpdate();
            if (count != 1){
                throw new PersistException("On update modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public void delete(Model model) throws PersistException {
        try (PreparedStatement pstm = connection.prepareStatement(deleteQuery)){
            pstm.setInt(1, model.getId());
            int count = pstm.executeUpdate();
            if (count != 1){
                throw new PersistException("On delete modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public List<Model> getAll() throws PersistException {
        return select(";");
    }

    @Override
    public List<Model> select(String where) throws PersistException {
        String sql = selectQuery + where;
        List<Model> selectModels = null;
        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            selectModels = parseResultSet(pstm.executeQuery());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return selectModels;
    }



    //Set parametrs of PreparedStatement
    protected abstract void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException;

    //Returns a list of objects from Result Set
    protected abstract List<Model> parseResultSet(ResultSet rs) throws SQLException;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
