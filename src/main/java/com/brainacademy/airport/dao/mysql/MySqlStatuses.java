package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Model;
import com.brainacademy.airport.model.Statuses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlStatuses extends MySqlRecord {
    public MySqlStatuses(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM statuses";
        selectLastInsert = " WHERE status_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE status_id = ?;";
        createQuery = "INSERT INTO statuses(status) VALUE (?);";
        updateQuery = "UPDATE statuses SET status = ? WHERE status_id = ?;";
        deleteQuery = "DELETE FROM statuses WHERE status_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Statuses status = (Statuses) model;
        ps.setString(1, status.getStatus());
        if (where){
            ps.setInt(2, status.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Statuses status = new Statuses();
            status.setId(rs.getInt("status_id"));
            status.setStatus(rs.getString("status"));
            result.add(status);
        }
        return result;
    }
}
