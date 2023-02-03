package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String USR="jdbc:mysql://localhost:3306/library";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DatabaseConnection(){
        try {
            connection = DriverManager.getConnection(USR, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
