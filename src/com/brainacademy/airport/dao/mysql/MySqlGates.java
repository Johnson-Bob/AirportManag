package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Classes;
import com.brainacademy.airport.model.Gates;
import com.brainacademy.airport.model.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlGates extends MySqlRecords {
    public MySqlGates(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM gates";
        selectLastInsert = " WHERE gate_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE gate_id = ?;";
        createQuery = "INSERT INTO gates(number) VALUE (?);";
        updateQuery = "UPDATE gates SET number = ? WHERE gate_id = ?;";
        deleteQuery = "DELETE FROM gates WHERE gate_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Gates gate = (Gates)model;
        ps.setInt(1, gate.getNumber());
        if (where){
            ps.setInt(2, gate.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Gates gate = new Gates();
            gate.setId(rs.getInt("gate_id"));
            gate.setNumber(rs.getInt("number"));
            result.add(gate);
        }
        return result;
    }
}
