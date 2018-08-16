package db;

import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

/**
 * Created by Ketter Collins on 20/05/2018.
 */
public class dbCon {
private static Connection connection=null;
public static Connection getConnection(){

    try {
        forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    try {
        connection= DriverManager.getConnection("jdbc:sqlite:userDb.db");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return connection;
}

}

