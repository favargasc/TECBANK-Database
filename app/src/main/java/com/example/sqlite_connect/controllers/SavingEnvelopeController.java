package com.example.sqlite_connect.controllers;

import com.example.sqlite_connect.config.DBConnection;
import com.example.sqlite_connect.models.SavingEnvelope;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public void receiveMoney(Integer saving_envelope_id, Double amount) {
        String updateSE =   "UPDATE saving_envelope SET current_balance = se.current_balance + ? FROM saving_envelope se INNER JOIN account a on a.id = se.account_id WHERE se.id = ? AND a.current_balance >= ?";
        String updateA  =   "UPDATE account SET current_balance = a.current_balance - ? FROM saving_envelope se INNER JOIN account a on a.id = se.account_id WHERE se.id = ? AND a.current_balance >= ?";

       try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

           PreparedStatement statementUpdateSE = connection.prepareStatement(updateSE);
           statementUpdateSE.setDouble(1, amount);
           statementUpdateSE.setInt(2, saving_envelope_id);
           statementUpdateSE.setDouble(3, amount);
           statementUpdateSE.executeUpdate();

           PreparedStatement statementUpdateA = connection.prepareStatement(updateA);
           statementUpdateA.setDouble(1, amount);
           statementUpdateA.setInt(2, saving_envelope_id);
           statementUpdateA.setDouble(3, amount);
           statementUpdateA.executeUpdate();

            connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
    }


}


