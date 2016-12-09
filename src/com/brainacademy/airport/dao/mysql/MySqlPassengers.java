package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Flights;
import com.brainacademy.airport.model.Model;
import com.brainacademy.airport.model.Passengers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlPassengers extends MySqlRecords {
    public MySqlPassengers(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM passengers";
        selectLastInsert = " WHERE pass_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE pass_id = ?;";
        createQuery = "INSERT INTO passengers(first_name, second_name, nationality, passport, birthday, sex)"
                + " VALUE (?, ?, ?, ?, ?, ?);";
        updateQuery = "UPDATE passengers SET first_name = ?, second_name = ?, nationality = ?, passport = ?,"
                + " birthday = ?, sex = ? WHERE pass_id = ?;";
        deleteQuery = "DELETE FROM passengers WHERE pass_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Passengers passenger = (Passengers) model;
        ps.setString(1, passenger.getFirstName());
        ps.setString(2, passenger.getSecondName());
        ps.setInt(3, passenger.getNationality());
        ps.setString(4, passenger.getPassport());
        ps.setDate(5, passenger.getBirthday());
        ps.setInt(6, passenger.getSex());
        if (where){
            ps.setInt(7, passenger.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Passengers passenger = new Passengers();
            passenger.setId(rs.getInt("pass_id"));
            passenger.setFirstName(rs.getString("first_name"));
            passenger.setSecondName(rs.getString("second_name"));
            passenger.setNationality(rs.getInt("nationality"));
            passenger.setPassport(rs.getString("passport"));
            passenger.setBirthday(rs.getDate("birthday"));
            passenger.setSex(rs.getInt("sex"));
            result.add(passenger);
        }
        return result;
    }
}
