package com.example.gg;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE_NAME = "Customer";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE_NAME;
        return DriverManager.getConnection(url, USER, PASSWORD);
    }
}
