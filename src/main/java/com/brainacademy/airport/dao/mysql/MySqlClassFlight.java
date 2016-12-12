package com.brainacademy.airport.dao.mysql;

import com.brainacademy.airport.entity.ClassFlight;
import com.brainacademy.airport.entity.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class MySqlClassFlight extends MySqlRecord<ClassFlight> {
    public MySqlClassFlight(Connection connection) {
        super(connection);
        selectQuery = "SELECT * FROM classes";
        selectLastInsert = " WHERE class_id = LAST_INSERT_ID();";
        readQuery = selectQuery + " WHERE class_id = ?;";
        createQuery = "INSERT INTO classes(class_name) VALUE (?);";
        updateQuery = "UPDATE classes SET class_name = ? WHERE class_id = ?;";
        deleteQuery = "DELETE FROM classes WHERE class_id = ?;";
    }

    @Override
    protected void setPreparedStatement(PreparedStatement ps, ClassFlight entity, boolean where) throws SQLException {
        ps.setString(1, entity.getClassFlight());
        if (where){
            ps.setInt(2, entity.getId());
        }
    }

    @Override
    protected List<ClassFlight> parseResultSet(ResultSet rs) throws SQLException {
        List<ClassFlight> result = new ArrayList<>();
        while (rs.next()){
            ClassFlight classFlight = new ClassFlight();
            classFlight.setId(rs.getInt("class_id"));
            classFlight.setClassFlight(rs.getString("class_name"));
            result.add(classFlight);
        }
        return result;
    }
}
