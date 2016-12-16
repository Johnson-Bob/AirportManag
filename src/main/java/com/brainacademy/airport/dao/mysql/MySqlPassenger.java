package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.dao.PersistException;
import com.brainacademy.airport.entity.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlPassenger extends MySqlRecord<Passenger> {
    public MySqlPassenger(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM passengers";
        selectLastInsert = " WHERE pass_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE pass_id = ?;";
        createQuery = "INSERT INTO passengers(first_name, second_name, nationality, passport, birthday, gender)"
                + " VALUE (?, ?, ?, ?, ?, ?);";
        updateQuery = "UPDATE passengers SET first_name = ?, second_name = ?, nationality = ?, passport = ?,"
                + " birthday = ?, gender = ? WHERE pass_id = ?;";
        deleteQuery = "DELETE FROM passengers WHERE pass_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Passenger entity, boolean where) throws SQLException {
        ps.setString(1, entity.getFirstName());
        ps.setString(2, entity.getSecondName());
        ps.setInt(3, entity.getNationality());
        ps.setString(4, entity.getPassport());
        ps.setDate(5, entity.getBirthday());
        ps.setString(6, entity.getGender());
        if (where){
            ps.setInt(7, entity.getId());
        }
    }

    @Override
    protected List<Passenger> parseResultSet(ResultSet rs) throws PersistException, SQLException {
        List<Passenger> result = new ArrayList<>();
        while (rs.next()){
                Passenger passenger = new Passenger();
                passenger.setId(rs.getInt("pass_id"));
                passenger.setFirstName(rs.getString("first_name"));
                passenger.setSecondName(rs.getString("second_name"));
                passenger.setNationality(rs.getInt("nationality"));
                passenger.setPassport(rs.getString("passport"));
                passenger.setBirthday(rs.getDate("birthday"));
                passenger.setGender(rs.getString("gender"));
                result.add(passenger);
            }
        return result;
    }
}
