package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.entity.Entity;
import com.brainacademy.airport.entity.Nationality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlNationality extends MySqlRecord<Nationality> {
    public MySqlNationality(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM nationalities";
        selectLastInsert = " WHERE nat_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE nat_id = ?;";
        createQuery = "INSERT INTO nationalities(nationality) VALUE (?);";
        updateQuery = "UPDATE nationalities SET nationality = ? WHERE nat_id = ?;";
        deleteQuery = "DELETE FROM nationalities WHERE nat_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Nationality entity, boolean where) throws SQLException {
        ps.setString(1, entity.getNationality());
        if (where){
            ps.setInt(2, entity.getId());
        }
    }

    @Override
    protected List<Nationality> parseResultSet(ResultSet rs) throws SQLException {
        List<Nationality> result = new ArrayList<>();
        while (rs.next()){
            Nationality nationality = new Nationality();
            nationality.setId(rs.getInt("nat_id"));
            nationality.setNationality(rs.getString("nationality"));
            result.add(nationality);
        }
        return result;
    }
}
