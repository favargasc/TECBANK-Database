package com.example.sqlite_connect.controllers;

import com.example.sqlite_connect.config.DBConnection;
import com.example.sqlite_connect.models.SavingEnvelope;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SavingEnvelopeController {
    public ArrayList<SavingEnvelope> getSavingEnvelopeByAccountId(Integer account_id) {
        String query = "SELECT * FROM saving_envelope where account_id =" + account_id.toString();
        ArrayList<SavingEnvelope> SavingEnvelopes = new ArrayList<>();

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            Statement statement = connection.createStatement();
            ResultSet response = statement.executeQuery(query);

            while (response.next()) {
                SavingEnvelopes.add(new SavingEnvelope (
                    response.getInt("id"),
                    response.getString("name"),
                    response.getDouble("current_balance")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return SavingEnvelopes;
    }
}
