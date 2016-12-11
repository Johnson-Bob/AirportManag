package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Model;
import com.brainacademy.airport.model.Terminals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlTerminals extends MySqlRecord {
    public MySqlTerminals(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM terminals";
        selectLastInsert = " WHERE terminal_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE terminal_id = ?;";
        createQuery = "INSERT INTO terminals(terminal) VALUE (?);";
        updateQuery = "UPDATE terminals SET terminal = ? WHERE terminal_id = ?;";
        deleteQuery = "DELETE FROM terminals WHERE terminal_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Terminals terminal = (Terminals) model;
        ps.setString(1, terminal.getTerminal());
        if (where){
            ps.setInt(2, terminal.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Terminals terminal = new Terminals();
            terminal.setId(rs.getInt("terminal_id"));
            terminal.setTerminal(rs.getString("terminal"));
            result.add(terminal);
        }
        return result;
    }
}
