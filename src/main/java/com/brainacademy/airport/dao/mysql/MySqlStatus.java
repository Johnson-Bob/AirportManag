package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.entity.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlStatus extends MySqlRecord<Status> {
    public MySqlStatus(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM statuses";
        selectLastInsert = " WHERE status_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE status_id = ?;";
        createQuery = "INSERT INTO statuses(status) VALUE (?);";
        updateQuery = "UPDATE statuses SET status = ? WHERE status_id = ?;";
        deleteQuery = "DELETE FROM statuses WHERE status_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Status entity, boolean where) throws SQLException {
        ps.setString(1, entity.getStatus());
        if (where){
            ps.setInt(2, entity.getId());
        }
    }

    @Override
    protected List<Status> parseResultSet(ResultSet rs) throws SQLException {
        List<Status> result = new ArrayList<>();
        while (rs.next()){
            Status status = new Status();
            status.setId(rs.getInt("status_id"));
            status.setStatus(rs.getString("status"));
            result.add(status);
        }
        return result;
    }
}
