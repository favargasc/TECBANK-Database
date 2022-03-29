package com.example.sqlite_connect.controllers;

import com.example.sqlite_connect.config.DBConnection;
import com.example.sqlite_connect.models.Account2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountController {
    public ArrayList<Account2> getAccountsByUserId(Integer user_id) {
        String query =  "SELECT * FROM account " +
                        "WHERE user_id = " + user_id.toString();
        ArrayList<Account2> account2s = new ArrayList<>();

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            Statement statement = connection.createStatement();
            ResultSet response = statement.executeQuery(query);

            while (response.next()) {
                account2s.add(new Account2(
                    response.getInt("id"),
                    response.getString("account_number"),
                    response.getDouble("current_balance")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return account2s;
    }
}
