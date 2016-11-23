package com.brainacademy.airport.dal.mysql;

import com.brainacademy.airport.dal.dao.DaoFlights;
import com.brainacademy.airport.model.Flights;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gladi on 23.11.2016.
 */
public class MysqlFlights implements DaoFlights {
    private Connection conn;

    public MysqlFlights() {
    }

    public MysqlFlights(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Flights create() {
        return null;
    }

    @Override
    public Flights read(int key) {
        return null;
    }

    @Override
    public void update(Flights group) {

    }

    @Override
    public void delete(Flights group) {

    }

    @Override
    public List<Flights> getAll() throws SQLException {
        return null;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
