package com.example.sqlite_connect.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static final String path = "jdbc:sqlite:C:\\Users\\anagu\\OneDrive\\Documentos\\TEC\\SemestreI2022\\Requerimientos\\GilbertsBranch\\TECBANK-Database\\tecbank.sqlite";

    public Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(path);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }
}
