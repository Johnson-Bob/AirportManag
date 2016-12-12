package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.entity.Entity;
import com.brainacademy.airport.entity.Price;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlPrice extends MySqlRecord<Price> {
    public MySqlPrice(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM prices";
        selectLastInsert = " WHERE prices_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE prices_id = ?;";
        createQuery = "INSERT INTO prices(flight, class, price)"
                + " VALUE (?, ?, ?);";
        updateQuery = "UPDATE prices SET flight = ?, class = ?, price = ? WHERE prices_id = ?;";
        deleteQuery = "DELETE FROM prices WHERE prices_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Price entity, boolean where) throws SQLException {
        ps.setInt(1, entity.getFlight());
        ps.setInt(2, entity.getClassFlight());
        ps.setFloat(3, entity.getPrice());
        if (where){
            ps.setInt(4, entity.getId());
        }
    }

    @Override
    protected List<Price> parseResultSet(ResultSet rs) throws SQLException {
        List<Price> result = new ArrayList<>();
        while (rs.next()){
            Price price = new Price();
            price.setId(rs.getInt("prices_id"));
            price.setFlight(rs.getInt("flight"));
            price.setClassFlight(rs.getInt("class"));
            price.setPrice(rs.getFloat("price"));
            result.add(price);
        }
        return result;
    }
}
