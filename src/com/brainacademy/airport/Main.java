package com.brainacademy.airport;

import com.brainacademy.airport.dao.DaoFactory;
import com.brainacademy.airport.dao.DaoRecords;
import com.brainacademy.airport.dao.PersistException;
import com.brainacademy.airport.dao.mysql.MysqlFactory;
import com.brainacademy.airport.model.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gladi on 08.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        DaoFactory mySQLfactory = new MysqlFactory();
        try (Connection connection = mySQLfactory.getConnection()){
            List<DaoRecords> mySQL = mySQLfactory.getDao(connection);
            Users user = new Users("Test", "test456", false);
            System.out.println(user);
            mySQL.get(0).create(user);
            System.out.println(user);
            System.out.println(mySQL.get(0).getAll());
            for (int i = 6; i <= 7; i++){
                mySQL.get(0).delete(mySQL.get(0).read(i));
            }
            user.setName("Vasya");
            mySQL.get(0).update(user);
            System.out.println(mySQL.get(0).getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }
}
