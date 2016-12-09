package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Classes;
import com.brainacademy.airport.model.Model;
import com.brainacademy.airport.model.Nationalities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlNationalities extends MySqlRecords {
    public MySqlNationalities(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM nationalities";
        selectLastInsert = " WHERE nat_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE nat_id = ?;";
        createQuery = "INSERT INTO nationalities(nationality) VALUE (?);";
        updateQuery = "UPDATE nationalities SET nationality = ? WHERE nat_id = ?;";
        deleteQuery = "DELETE FROM nationalities WHERE nat_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Nationalities nationalities = (Nationalities) model;
        ps.setString(1, nationalities.getNationality());
        if (where){
            ps.setInt(2, nationalities.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Nationalities nationality = new Nationalities();
            nationality.setId(rs.getInt("nat_id"));
            nationality.setNationality(rs.getString("nationality"));
            result.add(nationality);
        }
        return result;
    }
}
