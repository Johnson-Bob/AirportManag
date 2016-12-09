package com.brainacademy.airport;

import com.brainacademy.airport.dao.DaoFactory;
import com.brainacademy.airport.dao.DaoRecords;
import com.brainacademy.airport.dao.PersistException;
import com.brainacademy.airport.dao.mysql.FactoryMySql;
import com.brainacademy.airport.model.Cities;
import com.brainacademy.airport.model.Users;

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
            Map<String, DaoRecords> mySQL = mysqlFactory.getDao(connection);
            Users user = new Users("Test", "test456", false);
            Cities cities = new Cities();
            System.out.println(user);
            mySQL.get("users").create(user);
            mySQL.get("users").create(cities);
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
