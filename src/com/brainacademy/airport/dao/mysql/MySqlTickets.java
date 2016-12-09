package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Model;
import com.brainacademy.airport.model.Prices;
import com.brainacademy.airport.model.Tickets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlTickets extends MySqlRecords {
    public MySqlTickets(Connection connection) {
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
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Tickets ticket = (Tickets) model;
        ps.setInt(1, ticket.getPassenger());
        ps.setInt(2, ticket.getFlight());
        ps.setFloat(3, ticket.getClassFlight());
        if (where){
            ps.setInt(4, ticket.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Tickets ticket = new Tickets();
            ticket.setId(rs.getInt("ticket_id"));
            ticket.setPassenger(rs.getInt("passenger"));
            ticket.setFlight(rs.getInt("flight"));
            ticket.setClassFlight(rs.getInt("class"));
            result.add(ticket);
        }
        return result;
    }
}
