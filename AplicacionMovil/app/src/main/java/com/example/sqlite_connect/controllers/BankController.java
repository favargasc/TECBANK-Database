package com.example.sqlite_connect.controllers;

import com.example.sqlite_connect.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankController {
    public static int getBankId(String name) {
        String query =  "SELECT id FROM bank b " +
                "WHERE b.name = ? " ;

        int result = -1;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);

            ResultSet response = statement.executeQuery();

            result = response.getInt("id");

            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

}
