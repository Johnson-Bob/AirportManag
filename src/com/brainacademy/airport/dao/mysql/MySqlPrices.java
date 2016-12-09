package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Model;
import com.brainacademy.airport.model.Prices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlPrices extends MySqlRecords {
    public MySqlPrices(Connection connection) {
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
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Prices price = (Prices) model;
        ps.setInt(1, price.getFlight());
        ps.setInt(2, price.getClassFlight());
        ps.setFloat(3, price.getPrice());
        if (where){
            ps.setInt(4, price.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Prices price = new Prices();
            price.setId(rs.getInt("prices_id"));
            price.setFlight(rs.getInt("flight"));
            price.setClassFlight(rs.getInt("class"));
            price.setPrice(rs.getFloat("price"));
            result.add(price);
        }
        return result;
    }
}
