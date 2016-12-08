package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Model;
import com.brainacademy.airport.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlUsers extends MySqlRecords {
    public MySqlUsers(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM users";
        selectLastInsert = " WHERE user_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE user_id = ?;";
        createQuery = "INSERT INTO users(name, password, staff) VALUE (?, ?, ?);";
        updateQuery = "UPDATE users SET name = ?, password = ?, staff = ? WHERE user_id = ?;";
        deleteQuery = "DELETE FROM users WHERE user_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Users users = (Users)model;
        ps.setString(1, users.getName());
        ps.setString(2, users.getPassword());
        ps.setBoolean(3, users.isStaff());
        if (where){
            ps.setInt(4, users.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Users user = new Users();
            user.setId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getNString("password"));
            user.setStaff(rs.getBoolean("staff"));
            result.add(user);
        }
        return result;
    }
}
