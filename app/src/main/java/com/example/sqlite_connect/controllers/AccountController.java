package com.example.sqlite_connect.controllers;

import com.example.sqlite_connect.config.DBConnection;
import com.example.sqlite_connect.models.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountController {
    public ArrayList<Account> getAccountsByUserId(Integer user_id) {
        String query = "SELECT * FROM account where user_id = " + user_id.toString();
        ArrayList<Account> accounts = new ArrayList<>();

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            Statement statement = connection.createStatement();
            ResultSet response = statement.executeQuery(query);

            while (response.next()) {
                accounts.add(new Account(
                    response.getInt("id"),
                    response.getInt("account_number"),
                    response.getDouble("current_balance")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return accounts;
    }
}
