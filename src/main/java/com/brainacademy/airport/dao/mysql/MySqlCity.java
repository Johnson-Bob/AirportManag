package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.entity.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlCity extends MySqlRecord<City> {
    public MySqlCity(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM cities";
        selectLastInsert = " WHERE city_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE city_id = ?;";
        createQuery = "INSERT INTO cities(name) VALUE (?);";
        updateQuery = "UPDATE cities SET name = ? WHERE city_id = ?;";
        deleteQuery = "DELETE FROM cities WHERE city_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, City entity, boolean where) throws SQLException {
        ps.setString(1, entity.getName());
        if (where){
            ps.setInt(2, entity.getId());
        }
    }

    @Override
    protected List<City> parseResultSet(ResultSet rs) throws SQLException {
        List<City> result = new ArrayList<>();
        while (rs.next()){
            City city = new City();
            city.setId(rs.getInt("city_id"));
            city.setName(rs.getString("name"));
            result.add(city);
        }
        return result;
    }
}
