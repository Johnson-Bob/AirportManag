package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.entity.Entity;
import com.brainacademy.airport.entity.Terminal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlTerminal extends MySqlRecord<Terminal> {
    public MySqlTerminal(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM terminals";
        selectLastInsert = " WHERE terminal_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE terminal_id = ?;";
        createQuery = "INSERT INTO terminals(terminal) VALUE (?);";
        updateQuery = "UPDATE terminals SET terminal = ? WHERE terminal_id = ?;";
        deleteQuery = "DELETE FROM terminals WHERE terminal_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Terminal entity, boolean where) throws SQLException {
        ps.setString(1, entity.getTerminal());
        if (where){
            ps.setInt(2, entity.getId());
        }
    }

    @Override
    protected List<Terminal> parseResultSet(ResultSet rs) throws SQLException {
        List<Terminal> result = new ArrayList<>();
        while (rs.next()){
            Terminal terminal = new Terminal();
            terminal.setId(rs.getInt("terminal_id"));
            terminal.setTerminal(rs.getString("terminal"));
            result.add(terminal);
        }
        return result;
    }
}
