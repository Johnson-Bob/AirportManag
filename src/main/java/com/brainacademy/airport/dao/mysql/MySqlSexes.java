package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Model;
import com.brainacademy.airport.model.Sexes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlSexes extends MySqlRecord {
    public MySqlSexes(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM sexes";
        selectLastInsert = " WHERE sex_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE sex_id = ?;";
        createQuery = "INSERT INTO sexes(sex) VALUE (?);";
        updateQuery = "UPDATE sexes SET sex = ? WHERE sex_id = ?;";
        deleteQuery = "DELETE FROM sexes WHERE sex_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Sexes sex = (Sexes) model;
        ps.setString(1, sex.getSex());
        if (where){
            ps.setInt(2, sex.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Sexes sex = new Sexes();
            sex.setId(rs.getInt("sex_id"));
            sex.setSex(rs.getString("sex"));
            result.add(sex);
        }
        return result;
    }
}
