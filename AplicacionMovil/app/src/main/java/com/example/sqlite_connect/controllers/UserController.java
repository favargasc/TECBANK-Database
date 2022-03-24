package com.example.sqlite_connect.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.sqlite_connect.config.DBConnection;
import com.example.sqlite_connect.controllers.BankController;

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

    public static int getUserId(String userName) {
        String query =  "SELECT id FROM user u " +
                "WHERE u.user_name = ? " ;

        int result = -1;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userName);

            ResultSet response = statement.executeQuery();

            result = response.getInt("id");

            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public void newUser(String email, String userName, String password, String name, String lastName){

        int tecbankId = BankController.getBankId("TECBANK");
        //int tecbankId = 21;

        String query = "insert into user (email, password, name, last_name, bank_id, user_name)" +
                                " values (?, ?, ?, ?, ?, ?);";

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, name);
            statement.setString(3, lastName);
            statement.setInt(4, tecbankId);
            statement.setString(5, userName);

            ResultSet response = statement.executeQuery();

            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //return result;
    }
}