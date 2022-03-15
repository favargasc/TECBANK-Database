package com.example.sqlite_connect.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.sqlite_connect.config.DBConnection;

public class UserController {
    public int getUserId(String userName, String password) {
        String query =  "SELECT id FROM user u " +
                        "WHERE u.user_name = ? " +
                        "AND u.password = ?";

        int result = -1;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            statement.setString(2, password);

            ResultSet response = statement.executeQuery();

            result = response.getInt("id");

            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}