package com.brainacademy.airport;

import com.brainacademy.airport.dao.DaoFactory;
import com.brainacademy.airport.dao.DaoRecord;
import com.brainacademy.airport.dao.PersistException;
import com.brainacademy.airport.dao.mysql.FactoryMySql;
import com.brainacademy.airport.entity.City;
import com.brainacademy.airport.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by gladi on 08.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        DaoFactory mysqlFactory = new FactoryMySql();
        try (Connection connection = mysqlFactory.getConnection()){
            Map<String, DaoRecord> mySQL = mysqlFactory.getDao(connection);
            User user = new User("Test", "test456", false);
            City city = new City();
            System.out.println(user);
            mySQL.get("users").create(user);
            mySQL.get("users").create(city);
            System.out.println(user);
            System.out.println(mySQL.get("Users").getAll());
            for (int i = 8; i <= 9; i++){
                mySQL.get("Users").delete(mySQL.get("Users").read(i));
            }
            user.setName("Vasya");
            mySQL.get("Users").update(user);
            System.out.println(mySQL.get("Users").getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }
}
