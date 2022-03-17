package com.example.sqlite_connect.controllers;

import com.example.sqlite_connect.config.DBConnection;
import com.example.sqlite_connect.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountController {
    public ArrayList<Account> getAccountsByUserId(Integer user_id) {
        String query =  "SELECT * FROM account " +
                        "WHERE user_id = " + user_id.toString();
        ArrayList<Account> accounts = new ArrayList<>();

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            Statement statement = connection.createStatement();
            ResultSet response = statement.executeQuery(query);

            while (response.next()) {
                accounts.add(new Account(
                    response.getInt("id"),
                    response.getString("account_number"),
                    response.getDouble("current_balance")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return accounts;
    }

    public boolean localTransfer (
        String reqAccount,
        String resAccount,
        String IDCard,
        String detail,
        double amount
    ) {
        String query  =     "UPDATE account " +
                            "SET current_balance = current_balance + ? " +
                            "WHERE account_number = ?";


        if (this.reduceAccountCB(reqAccount, amount) || getAccount(resAccount) == null) return false;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, amount);
            statement.setString(2, resAccount);

            statement.executeUpdate();
            this.saveInLog(reqAccount, resAccount, IDCard, detail, amount, 1, 0, 1);

            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

    public boolean externalTransfer (
        String reqAccount,
        String resAccount,
        String IDCard,
        String detail,
        double amount,
        double commission,
        int bankId
    ) {

        if (this.reduceAccountCB(reqAccount, amount)) return false;

        this.saveInLog(reqAccount, resAccount, IDCard, detail, amount, 2, commission, bankId);

        return true;
    }

    private boolean reduceAccountCB(String accountNumber, double amount) {
        String query =  "UPDATE account " +
                        "SET current_balance = current_balance - ? " +
                        "WHERE id = ?";

        Account account = this.getAccount(accountNumber);

        if (account == null || account.getCurrent_balance() < amount) return true;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setDouble(1, amount);
            statement.setInt(2, account.getId());

            statement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    private Account getAccount(String accountNumber) {
        String query =  "SELECT * FROM account WHERE account_number = ?";

        Account result = null;

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, accountNumber);

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

    private void saveInLog(
        String reqAccount,
        String resAccount,
        String IDCard,
        String detail,
        double amount,
        int TransactionType,
        double commission,
        int bankId
    )
    {
        String query  =     "INSERT INTO proof_of_payment (req_account, res_account, id_card, amount, detail, transaction_type_id, commission, bank_id) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, reqAccount);
            statement.setString(2, resAccount);
            statement.setString(3, IDCard);
            statement.setDouble(4, amount);
            statement.setString(5, detail);
            statement.setInt(6, TransactionType);
            statement.setDouble(7, commission);
            statement.setInt(8, bankId);

            statement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
