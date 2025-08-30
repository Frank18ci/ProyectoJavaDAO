package org.carpio.com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class ConnectionToSql {
    public static Connection getConnection() {
        Connection connection = null;
        final String url = "jdbc:sqlite:C:\\Users\\fcarp\\Desktop\\FC\\NTTDATAJAVA\\SQLLite\\cine";
        //final String url = "jdbc:sqlite:C:/Users/fcarp/Desktop/FC/NTTDATAJAVA/SQLLite/cine";
        try {
            connection = DriverManager.getConnection(url);
            //Class.forName("org.sqlite.JDBC");
        } catch (SQLDataException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return connection;
    }

}
