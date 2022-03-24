package com.example.sqlite_connect.controllers;

import com.example.sqlite_connect.config.DBConnection;
import com.example.sqlite_connect.models.Account;
import com.example.sqlite_connect.models.SavingEnvelope;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class SavingEnvelopeController {
    public ArrayList<SavingEnvelope> getSavingEnvelopeByAccountId(int account_id) {
        String query = "SELECT * FROM saving_envelope where account_id = " + account_id;
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

    public ArrayList<SavingEnvelope> getSavingEnvelopeByUserName(String userName) {
        String query = "SELECT * FROM saving_envelope where account_id = " + UserController.getUserId(userName);
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

    public boolean receiveMoney(int savingEnvelopeId, double amount) {
        String query  =     "UPDATE saving_envelope " +
                            "SET current_balance = current_balance + ? " +
                            "WHERE id = ?";

        if (!this.reduceAccountCB(savingEnvelopeId, amount)) return false;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setDouble(1, amount);
            statement.setInt(2, savingEnvelopeId);
            statement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
       return true;
    }

    public boolean returnMoney(int savingEnvelopeId, double amount) {
        String query  =     "UPDATE saving_envelope " +
                            "SET current_balance = current_balance - ? " +
                            "WHERE id = ?";

        SavingEnvelope savingEnvelope =  getSavingEnvelope(savingEnvelopeId);

        if (savingEnvelope == null  || savingEnvelope.getCurrent_balance() < amount) return false;
        if (!this.increaseAccountCB(savingEnvelopeId, amount)) return false;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setDouble(1, amount);
            statement.setInt(2, savingEnvelopeId);

            statement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

    public void delete(int savingEnvelopeId) {
        String query  =     "DELETE FROM saving_envelope " +
                            "WHERE id = ?";
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, savingEnvelopeId);
            statement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private Account getAccount(int savingEnvelopeId) {
        String query =  "SELECT a.id, a.account_number, a.current_balance " +
                        "FROM saving_envelope se " +
                        "INNER JOIN account a " +
                        "ON a.id = se.account_id " +
                        "WHERE se.id = ?";

        Account result = null;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, savingEnvelopeId);

            ResultSet response = statement.executeQuery();

            result = new Account (
                response.getInt("id"),
                response.getString("account_number"),
                response.getDouble("current_balance")
            );

            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    private SavingEnvelope getSavingEnvelope(int savingEnvelopeId) {
        String query =  "select id, name, current_balance " +
                        "from saving_envelope " +
                        "where id = ?";

        SavingEnvelope result = null;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, savingEnvelopeId);

            ResultSet response = statement.executeQuery();

            result = new SavingEnvelope (
                response.getInt("id"),
                response.getString("name"),
                response.getDouble("current_balance")
            );

            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    private boolean reduceAccountCB(int savingEnvelopeId, double amount) {
        String query =  "UPDATE account " +
                        "SET current_balance = current_balance - ? " +
                        "WHERE id = ?";

        Account account = this.getAccount(savingEnvelopeId);

        if (account == null || account.getCurrent_balance() < amount) return false;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setDouble(1, amount);
            statement.setInt(2, account.getId());

            statement.executeUpdate();

            this.saveInLog(amount, new Date().toString(), 1);
            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

    private boolean increaseAccountCB(int savingEnvelopeId, double amount) {
        String query =  "UPDATE account " +
            "SET current_balance = current_balance + ? " +
            "WHERE id = ?";

        Account account = this.getAccount(savingEnvelopeId);

        if (account == null) return false;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setDouble(1, amount);
            statement.setInt(2, account.getId());

            statement.executeUpdate();

            this.saveInLog(amount, new Date().toString(), 2);

            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

    private void saveInLog(double amount, String date, int transaction_type_id) {
        String query  =     "INSERT INTO saving_envelope_log (amount, date, transaction_type_id) " +
                            "VALUES (?, ?, ?)";
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setDouble(1, amount);
            statement.setString(2, date);
            statement.setInt(3, transaction_type_id);

            statement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}


