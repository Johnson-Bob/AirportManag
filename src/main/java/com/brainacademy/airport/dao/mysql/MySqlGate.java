package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.entity.Gate;
import com.brainacademy.airport.entity.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlGate extends MySqlRecord<Gate> {
    public MySqlGate(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM gates";
        selectLastInsert = " WHERE gate_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE gate_id = ?;";
        createQuery = "INSERT INTO gates(number) VALUE (?);";
        updateQuery = "UPDATE gates SET number = ? WHERE gate_id = ?;";
        deleteQuery = "DELETE FROM gates WHERE gate_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Gate entity, boolean where) throws SQLException {
        ps.setInt(1, entity.getNumberGate());
        if (where){
            ps.setInt(2, entity.getId());
        }
    }

    @Override
    protected List<Gate> parseResultSet(ResultSet rs) throws SQLException {
        List<Gate> result = new ArrayList<>();
        while (rs.next()){
            Gate gate = new Gate();
            gate.setId(rs.getInt("gate_id"));
            gate.setNumberGate(rs.getInt("number"));
            result.add(gate);
        }
        return result;
    }
}
