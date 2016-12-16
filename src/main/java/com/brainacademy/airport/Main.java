package com.brainacademy.airport;

import com.brainacademy.airport.dao.DaoFactory;
import com.brainacademy.airport.dao.DaoRecord;
import com.brainacademy.airport.dao.PersistException;
import com.brainacademy.airport.dao.mysql.FactoryMySql;
import com.brainacademy.airport.entity.Flight;
import com.brainacademy.airport.ui.AirlineInfo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by gladi on 08.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        DaoFactory mysqlFactory = new FactoryMySql();
        try (Connection connection = mysqlFactory.getConnection()){
            Map<String, DaoRecord> dao = mysqlFactory.getDao(connection);
            List<Flight> flights = dao.get("flights").getAll();
            System.out.println(flights.get(0).getDate());
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    AirlineInfo.createAndShowGUI(new Vector<Flight>(flights));
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }
}
