package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlUser extends MySqlRecord<User> {
    public MySqlUser(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM users";
        selectLastInsert = " WHERE user_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE user_id = ?;";
        createQuery = "INSERT INTO users(name, password, staff) VALUE (?, ?, ?);";
        updateQuery = "UPDATE users SET name = ?, password = ?, staff = ? WHERE user_id = ?;";
        deleteQuery = "DELETE FROM users WHERE user_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, User entity, boolean where) throws SQLException {
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getPassword());
        ps.setBoolean(3, entity.isStaff());
        if (where){
            ps.setInt(4, entity.getId());
        }
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws SQLException {
        List<User> result = new ArrayList<>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getNString("password"));
            user.setStaff(rs.getBoolean("staff"));
            result.add(user);
        }
        return result;
    }
}
