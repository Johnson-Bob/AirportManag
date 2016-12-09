package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.model.Cities;
import com.brainacademy.airport.model.Classes;
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
public class MySqlClasses extends MySqlRecords {
    public MySqlClasses(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM classes";
        selectLastInsert = " WHERE class_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE class_id = ?;";
        createQuery = "INSERT INTO classes(class_name) VALUE (?);";
        updateQuery = "UPDATE classes SET class_name = ? WHERE class_id = ?;";
        deleteQuery = "DELETE FROM classes WHERE class_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, Model model, boolean where) throws SQLException {
        Classes classes = (Classes) model;
        ps.setString(1, classes.getClassName());
        if (where){
            ps.setInt(2, classes.getId());
        }
    }

    @Override
    protected List<Model> parseResultSet(ResultSet rs) throws SQLException {
        List<Model> result = new ArrayList<>();
        while (rs.next()){
            Classes classes = new Classes();
            classes.setId(rs.getInt("class_id"));
            classes.setClassName(rs.getString("class_name"));
            result.add(classes);
        }
        return result;
    }
}
