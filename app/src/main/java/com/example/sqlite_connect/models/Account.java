package com.example.sqlite_connect.models;

public class Account {
    int id, account_number;
    double current_balance;

    public Account(int id, int account_number, double current_balance) {
        this.id = id;
        this.account_number = account_number;
        this.current_balance = current_balance;
    }

    public int getId() {
        return id;
    }

    public int getAccount_number() {
        return account_number;
    }

    public double getCurrent_balance() {
        return current_balance;
    }

    public String to_String() {
        return "Account{" +
            "id=" + id +
            ", account_number=" + account_number +
            ", current_balance=" + current_balance +
            '}';
    }
}
