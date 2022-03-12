package com.example.sqlite_connect.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.sqlite_connect.config.DBConnection;
import com.example.sqlite_connect.models.User;

public class UserController {
    public ArrayList<User> getUsersByBankId(Integer bank_id) {
        String query = "SELECT * FROM user WHERE bank_id = " + bank_id.toString();
        ArrayList<User> users = new ArrayList<>();

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            Statement statement = connection.createStatement();
            ResultSet response = statement.executeQuery(query);

            while (response.next()) {
                users.add(new User(
                    response.getInt("id"),
                    response.getString("email"),
                    response.getString("password"),
                    response.getString("name"),
                    response.getString("last_name"),
                    response.getString("user_name")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }
}