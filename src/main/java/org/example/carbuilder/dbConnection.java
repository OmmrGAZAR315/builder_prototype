package org.example.carbuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static Connection connection = null;
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:8088/carbuilderdb";
    private static final String USER = "root";
    private static final String PASSWORD = "90950";

    private dbConnection() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException
            throw new RuntimeException("Failed to load MySQL JDBC driver", e);
        } catch (SQLException e) {
            // Handle SQLException
            throw new RuntimeException("Failed to establish database connection", e);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            // Handle SQLException
            e.printStackTrace();
        }
    }
}
