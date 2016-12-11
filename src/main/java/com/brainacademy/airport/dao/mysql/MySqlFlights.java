package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Flights;
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
public class MySqlFlights extends MySqlRecord {
    public MySqlFlights(Connection connection) {
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
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Flights flight = (Flights) model;
        ps.setString(1, flight.getType());
        ps.setDate(2, flight.getDate());
        ps.setString(3, flight.getNumber());
        ps.setInt(4, flight.getCity());
        ps.setInt(5, flight.getTerminal());
        ps.setInt(6, flight.getStatus());
        ps.setInt(7, flight.getGate());
        if (where){
            ps.setInt(8, flight.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Flights flight = new Flights();
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
