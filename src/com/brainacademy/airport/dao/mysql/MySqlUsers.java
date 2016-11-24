package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.dao.DaoUsers;
import com.brainacademy.airport.dao.PersistException;
import com.brainacademy.airport.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gladi on 24.11.2016.
 */
public class MySqlUsers implements DaoUsers {
    private Connection connection;
    private static final String selectQuery = "SELECT * FROM users";
    private static final String createQuery = "INSERT INTO users (`name`, `password`, `staff`) VALUES (?, ?, ?);";
    private static final String updateQuery = "UPDATE users SET `name` = ?, `password` = ?, `staff` = ?" +
            " WHERE `user_id` = ?;";
    private static final String deleteQuery = "DELETE FROM users WHERE `user_id` = ?;";

    public MySqlUsers() {
    }

    public MySqlUsers(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Users user) throws PersistException {
        if (user.getUserId() != null){
            throw new PersistException("Object is already persist.");
        }

        //Insert record
        try(PreparedStatement pstm = connection.prepareStatement(createQuery)) {
            setPreparedStatement(pstm, user);
            int count = pstm.executeUpdate();
            if (count != 1){
                throw new PersistException("On persist modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }

//        Get just inserting records and set userId
        List<Users> getUsers = select(" WHERE id = last_insert_id();");
        if (getUsers == null || getUsers.size() != 1){
            throw new PersistException("Received more than one record: " + getUsers.size());
        }else {
            user.setUserId(getUsers.get(0).getUserId());
        }
    }

    @Override
    public Users read(Integer id) throws PersistException {
        List<Users> selectUsers = null;
        String sql = selectQuery + " WHERE user_id = ?;";
        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.setInt(1, id);
            selectUsers = parseResultSet(pstm.executeQuery());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        if (selectUsers == null || selectUsers.size() == 0){
            throw new PersistException("Record with `user_id` = " + id + " not found.");
        }
        if (selectUsers.size() > 1){
            throw new PersistException("Received more than one record: " + selectUsers.size());
        }
        return selectUsers.iterator().next();
    }

    @Override
    public void update(Users user) throws PersistException {
        try (PreparedStatement pstm = connection.prepareStatement(updateQuery)){
            setPreparedStatement(pstm, user);
            pstm.setInt(4, user.getUserId());
            int count = pstm.executeUpdate();
            if (count != 1){
                throw new PersistException("On update modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public void delete(Users user) throws PersistException {
        try (PreparedStatement pstm = connection.prepareStatement(deleteQuery)){
            pstm.setInt(1, user.getUserId());
            int count = pstm.executeUpdate();
            if (count != 1){
                throw new PersistException("On delete modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public List<Users> getAll() throws PersistException {
        return select(";");
    }

    @Override
    public List<Users> select(String where) throws PersistException {
        String sql = selectQuery + where;
        List<Users> selectUsers = null;
        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            selectUsers = parseResultSet(pstm.executeQuery());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return selectUsers;
    }

    @Override
    public List<Users> parseResultSet(ResultSet rs) throws SQLException {
        List<Users> result = null;
        while (rs.next()){
            Users user = new Users();
            user.setUserId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getNString("password"));
            user.setStaff(rs.getBoolean("staff"));
            result.add(user);
        }
        return result;
    }

    @Override
    public void setPreparedStatement(PreparedStatement ps, Users user) throws SQLException {
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setBoolean(3, user.isStaff());
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
