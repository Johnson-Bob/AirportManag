package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Cities;
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
public class MySqlCities extends MySqlRecord {
    public MySqlCities(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM cities";
        selectLastInsert = " WHERE city_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE city_id = ?;";
        createQuery = "INSERT INTO cities(name) VALUE (?);";
        updateQuery = "UPDATE cities SET name = ? WHERE city_id = ?;";
        deleteQuery = "DELETE FROM cities WHERE city_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Cities city = (Cities) model;
        ps.setString(1, city.getName());
        if (where){
            ps.setInt(2, city.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Cities city = new Cities();
            city.setId(rs.getInt("city_id"));
            city.setName(rs.getString("name"));
            result.add(city);
        }
        return result;
    }
}
