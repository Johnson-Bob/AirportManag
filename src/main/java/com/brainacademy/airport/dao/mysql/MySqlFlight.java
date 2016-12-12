package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.dao.PersistException;
import com.brainacademy.airport.entity.Flight;
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
public class MySqlFlight extends MySqlRecord<Flight> {
    public MySqlFlight(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM flights";
        selectLastInsert = " WHERE flight_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE flight_id = ?;";
        createQuery = "INSERT INTO flights(type, dates, number, city, terminal, status, gate)"
                + " VALUE (?, ?, ?, ?, ?, ?, ?);";
        updateQuery = "UPDATE flights SET type = ?, dates = ?, number = ?, city = ?,"
                + " terminal = ?, status = ?, gate = ? WHERE flight_id = ?;";
        deleteQuery = "DELETE FROM flights WHERE flight_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Flight entity, boolean where) throws SQLException {
        ps.setString(1, entity.getType());
        ps.setDate(2, entity.getDate());
        ps.setString(3, entity.getNumber());
        ps.setInt(4, entity.getCity());
        ps.setInt(5, entity.getTerminal());
        ps.setInt(6, entity.getStatus());
        ps.setInt(7, entity.getGate());
        if (where){
            ps.setInt(8, entity.getId());
        }
    }

    @Override
    protected List<Flight> parseResultSet(ResultSet rs) throws PersistException, SQLException {
        List<Flight> result = new ArrayList<>();
        while (rs.next()){
                Flight flight = new Flight();
                flight.setId(rs.getInt("flight_id"));
                flight.setType(rs.getString("type"));
                flight.setDate(rs.getDate("dates"));
                flight.setNumber(rs.getString("number"));
                flight.setCity(rs.getInt("city"));
                flight.setTerminal(rs.getInt("terminal"));
                flight.setStatus(rs.getInt("status"));
                flight.setGate(rs.getInt("gate"));
                result.add(flight);
            }
        return result;
    }
}
