package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.entity.Entity;
import com.brainacademy.airport.entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlTicket extends MySqlRecord<Ticket> {
    public MySqlTicket(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM tickets";
        selectLastInsert = " WHERE ticket_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE ticket_id = ?;";
        createQuery = "INSERT INTO tickets(passenger, flight, class)"
                + " VALUE (?, ?, ?);";
        updateQuery = "UPDATE tickets SET passenger = ?, flight = ?, class = ? WHERE ticket_id = ?;";
        deleteQuery = "DELETE FROM tickets WHERE ticket_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Ticket entity, boolean where) throws SQLException {
        ps.setInt(1, entity.getPassenger());
        ps.setInt(2, entity.getFlight());
        ps.setFloat(3, entity.getClassFlight());
        if (where){
            ps.setInt(4, entity.getId());
        }
    }

    @Override
    protected List<Ticket> parseResultSet(ResultSet rs) throws SQLException {
        List<Ticket> result = new ArrayList<>();
        while (rs.next()){
            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("ticket_id"));
            ticket.setPassenger(rs.getInt("passenger"));
            ticket.setFlight(rs.getInt("flight"));
            ticket.setClassFlight(rs.getInt("class"));
            result.add(ticket);
        }
        return result;
    }
}
